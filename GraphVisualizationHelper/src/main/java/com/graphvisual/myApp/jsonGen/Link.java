
package com.graphvisual.myApp.jsonGen;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "source",
    "target",
    "value"
})
public class Link {

    @JsonProperty("source")
    private Integer source;
    @JsonProperty("target")
    private Integer target;
    @JsonProperty("value")
    private Integer value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Link() {
    }

    /**
     * 
     * @param source
     * @param value
     * @param target
     */
    public Link(Integer source, Integer target, Integer value) {
        this.source = source;
        this.target = target;
        this.value = value;
    }

    /**
     * 
     * @return
     *     The source
     */
    @JsonProperty("source")
    public Integer getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    @JsonProperty("source")
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The target
     */
    @JsonProperty("target")
    public Integer getTarget() {
        return target;
    }

    /**
     * 
     * @param target
     *     The target
     */
    @JsonProperty("target")
    public void setTarget(Integer target) {
        this.target = target;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("value")
    public Integer getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    @JsonProperty("value")
    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(source).append(target).append(value).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Link) == false) {
            return false;
        }
        Link rhs = ((Link) other);
        return new EqualsBuilder().append(source, rhs.source).append(target, rhs.target).append(value, rhs.value).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
