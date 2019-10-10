package com.example.consumer.openfeignService;

import com.example.consumer.entity.Depart;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 服务降级处理类
 */
@Component
public class DepartFallBackFactory implements FallbackFactory<DepartService> {
    @Override
    public DepartService create(Throwable throwable) {
        //返回feign接口的处理类
        return new DepartService() {
            @Override
            public Depart getDepartById(int id) {
                System.out.println("执行 getDepartById 方法");
                Depart depart = new Depart();
                depart.setId(id);
                depart.setName("feign process");
                return depart;
            }
        };
    }
}
