package org.kainos.ea.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobRoleNoId {

        private String name;
        private String specificationDesc;
        private String urlLink;
        private int bandid;
        private int capabilityid;

        public JobRoleNoId(@JsonProperty("Name") String name, @JsonProperty("Specification_Description") String specificationDesc, @JsonProperty("URL") String urlLink, @JsonProperty("BandLevel") int bandid, @JsonProperty("Capability") int capability) {
            setName(name);
            setSpecificationDesc(specificationDesc);
            setUrlLink(urlLink);
            setBand(bandid);
            setCapability(capability);
        }

        public String getUrlLink() {
            return urlLink;
        }

        public void setUrlLink(String urlLink) {
            this.urlLink = urlLink;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSpecificationDesc() {
            return specificationDesc;
        }

        public void setSpecificationDesc(String specificationDesc) {
            this.specificationDesc = specificationDesc;
        }

        public int getBand() {
            return bandid;
        }

        public void setBand(int bandid) {
            this.bandid = bandid;
        }

        public int getCapability() {
            return capabilityid;
        }

        public void setCapability(int capabilityid) {
            this.capabilityid = capabilityid;
        }

        @Override
        public String toString() {
            return "JobRoleNoId{" +
                    ", name='" + name + '\'' +
                    ", specificationDesc='" + specificationDesc + '\'' +
                    ", url_link='" + urlLink + '\'' +
                    ", bandid='" + bandid + '\'' +
                    ", capabilityid='" + capabilityid + '\'' +
                    '}';
        }
    }

