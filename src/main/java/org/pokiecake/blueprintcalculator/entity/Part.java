package org.pokiecake.blueprintcalculator.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Parts")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="part_id")
    private int partId;


    @Column(name="part_name")
    private String partName;

    @Column(name="company")
    private String company;

    public Part() {
    }

    public Part(int partId, String partName, String company) {
        this.partId = partId;
        this.partName = partName;
        this.company = company;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Part{" +
                "partId=" + partId +
                ", partName=" + partName +
                ", company=" + company +
                '}';
    }
}
