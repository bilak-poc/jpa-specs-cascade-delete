package com.example.demo.data.entity;

import jakarta.persistence.*;

@Entity
public class Alternative {

    @Id
    private String id;
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_demand_alternative"), nullable = false)
    private Demand demand;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }
}
