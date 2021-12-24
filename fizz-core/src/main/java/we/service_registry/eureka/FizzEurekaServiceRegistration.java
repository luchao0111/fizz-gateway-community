/*
 *  Copyright (C) 2020 the original author or authors.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package we.service_registry.eureka;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClientConfig;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.eureka.CloudEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaServiceRegistry;
import org.springframework.util.CollectionUtils;
import we.service_registry.FizzServiceRegistration;
import we.service_registry.RegistryCenter;
import we.util.Consts;
import we.util.Utils;

import java.util.*;

/**
 * @author hongqiaowei
 */

public class FizzEurekaServiceRegistration extends FizzServiceRegistration {

    private final CloudEurekaClient client;

    public FizzEurekaServiceRegistration(String id, EurekaRegistration registration, EurekaServiceRegistry serviceRegistry, CloudEurekaClient client) {
        super(id, registration, serviceRegistry);
        this.client = client;
    }

    public DiscoveryClient getDiscoveryClient() {
        return client;
    }

    @Override
    public RegistryCenter.Status getRegistryCenterStatus() {
        EurekaClientConfig eurekaClientConfig = client.getEurekaClientConfig();
        List<String> eurekaServerServiceUrls = eurekaClientConfig.getEurekaServerServiceUrls(EurekaClientConfigBean.DEFAULT_ZONE);
        Map<String, Integer> registryCenterVip2port = new HashMap<>();
        for (String serviceUrl : eurekaServerServiceUrls) {
            String vip;
            int port;
            int begin = serviceUrl.indexOf('p') + 4;
            int colon = serviceUrl.indexOf(':', begin);
            if (colon > -1) {
                int end = serviceUrl.indexOf('/', colon);
                vip = serviceUrl.substring(begin, colon);
                port = Integer.parseInt(serviceUrl.substring(colon + 1, end));
            } else {
                int end = serviceUrl.indexOf('/', begin);
                vip = serviceUrl.substring(begin, end);
                port = 80;
            }
            registryCenterVip2port.put(vip, port);
        }

        boolean f = false;
        for (Application registeredApplication : client.getApplications().getRegisteredApplications()) {
            List<InstanceInfo> instances = registeredApplication.getInstances();
            for (InstanceInfo instance : instances) {
                String vipAddress = instance.getVIPAddress();
                String ipAddr = instance.getIPAddr();
                Integer port = registryCenterVip2port.get(vipAddress);
                if (port == null) {
                    port = registryCenterVip2port.get(ipAddr);
                }
                if (port != null) {
                    int p = instance.getPort();
                    if (p == port) {
                        f = true;
                        break;
                    }
                }
            }
            if (f) {
                for (InstanceInfo instance : instances) {
                    InstanceInfo.InstanceStatus status = instance.getStatus();
                    if (status != InstanceInfo.InstanceStatus.UP) {
                        return transfrom(status);
                    }
                }
                return transfrom(InstanceInfo.InstanceStatus.UP);
            }
        }

        String join = StringUtils.join(eurekaServerServiceUrls, ',');
        throw Utils.runtimeExceptionWithoutStack("can't find any server with " + join);
    }

    private RegistryCenter.Status transfrom(InstanceInfo.InstanceStatus status) {
        if (       status == InstanceInfo.InstanceStatus.UP) {
            return RegistryCenter.Status.UP;

        } else if (status == InstanceInfo.InstanceStatus.DOWN) {
            return RegistryCenter.Status.DOWN;

        } else if (status == InstanceInfo.InstanceStatus.OUT_OF_SERVICE) {
            return RegistryCenter.Status.OUT_OF_SERVICE;

        } else if (status == InstanceInfo.InstanceStatus.STARTING) {
            return RegistryCenter.Status.STARTING;

        } else {
            return RegistryCenter.Status.UNKNOWN;
        }
    }

    @Override
    public List<String> getServices() {
        List<Application> registeredApplications = client.getApplications().getRegisteredApplications();
        if (registeredApplications.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<String> services = new ArrayList<>(registeredApplications.size());
            for (Application app : registeredApplications) {
                services.add(app.getName().toLowerCase());
            }
            return services;
        }
    }

    @Override
    public String getInstance(String service) {
        InstanceInfo inst = getInstanceInfo(service);
        return inst.getIPAddr() + Consts.S.COLON + inst.getPort();
    }

    public InstanceInfo getInstanceInfo(String service) {
        List<InstanceInfo> insts = client.getInstancesByVipAddress(service, false);
        if (CollectionUtils.isEmpty(insts)) {
            throw Utils.runtimeExceptionWithoutStack(getId() + " eureka no " + service);
        }
        Applications apps = client.getApplications();
        int index = (int) (apps.getNextIndex(service.toUpperCase(), false).incrementAndGet() % insts.size());
        return insts.get(index);
    }
}
