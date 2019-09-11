package com.qf.rules;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class CustomerRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    private int limit = 2 ;
    private int num = 0;
    private Server currentServer;

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer() , key);
    }

    public Server choose(ILoadBalancer lb ,Object key) {
        List<Server> reachableServers = lb.getReachableServers();
        if(null ==currentServer && null != reachableServers && reachableServers.size()>0) {
           currentServer =reachableServers.get(0);
           num++;
           return currentServer;
        }

        int size = reachableServers.size();
        for (int i = 0; i < size ; i++) {
            Server server = reachableServers.get(i);
            if(currentServer.getId().equals(server.getId())){
                if(num >= limit){
                    num = 0;
                    if(i == (size -1)){
                        currentServer = reachableServers.get(0);
                        num++;
                        return currentServer;
                    }else {
                        currentServer = reachableServers.get(++i);
                        num++;
                        return currentServer;
                    }
                }else{
                    num++;
                    return  currentServer;
                }
            }
        }

        return null;
    }
}
