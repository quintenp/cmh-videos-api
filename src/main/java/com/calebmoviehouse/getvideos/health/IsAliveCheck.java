package com.calebmoviehouse.getvideos.health;

import com.codahale.metrics.health.HealthCheck;

public class IsAliveCheck extends HealthCheck {
    public IsAliveCheck(){}

    @Override
    protected Result check(){
        return Result.healthy("I am alive");
    }
}
