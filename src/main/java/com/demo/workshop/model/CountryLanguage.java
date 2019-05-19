/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.workshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmed.Elsayed
 */
@Entity
@Table(name = "country_language", schema = "public")
public class CountryLanguage implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected CountryLanguagePK countryLanguagePK;
    @JsonIgnore
    @Column(name = "is_official")
    private boolean isOfficial;
    @JsonIgnore
    @Column(name = "percentage")
    private float percentage;
    @JsonIgnore
    @JoinColumn(name = "country_code", referencedColumnName = "code", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Country country;

    public CountryLanguage() {
    }

    public CountryLanguage(CountryLanguagePK countryLanguagePK) {
        this.countryLanguagePK = countryLanguagePK;
    }

    public CountryLanguage(CountryLanguagePK countryLanguagePK, boolean isOfficial, float percentage) {
        this.countryLanguagePK = countryLanguagePK;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public CountryLanguage(String countryCode, String language) {
        this.countryLanguagePK = new CountryLanguagePK(countryCode, language);
    }

    public CountryLanguagePK getCountryLanguagePK() {
        return countryLanguagePK;
    }

    public void setCountryLanguagePK(CountryLanguagePK countryLanguagePK) {
        this.countryLanguagePK = countryLanguagePK;
    }

    public boolean getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(boolean isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryLanguagePK != null ? countryLanguagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryLanguage)) {
            return false;
        }
        CountryLanguage other = (CountryLanguage) object;
        if ((this.countryLanguagePK == null && other.countryLanguagePK != null) || (this.countryLanguagePK != null && !this.countryLanguagePK.equals(other.countryLanguagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.demo.workshop.model.CountryLanguage[ countryLanguagePK=" + countryLanguagePK + " ]";
    }

}
