package com.example.consumer.config;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class CustomerRule implements IRule {

    private ILoadBalancer lb;
    private List<Integer> excludePort;

    public CustomerRule(){

    }
    public CustomerRule(List<Integer> excludePort) {
        this.excludePort = excludePort;
    }

    @Override
    public Server choose(Object key) {
        List<Server> servers = lb.getReachableServers();
//        List<Server> availableServers = ?
        return null;
    }

    @Override
    public void setLoadBalancer(ILoadBalancer lb) {
        this.lb = lb;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return lb;
    }
}
