
package com.graphvisual.myApp.jsonGen;

import java.io.Serializable;
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
public class Edge implements Serializable{

    @JsonProperty("source")
    private Integer source;
    @JsonProperty("target")
    private Integer target;
    @JsonProperty("value")
    private Double value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonIgnore
	private Node startNode;
    @JsonIgnore
	private Node targetNode;
    /**
     * No args constructor for use in serialization
     * 
     */
    public Edge() {
    }

    /**
     * 
     * @param source
     * @param value
     * @param target
     */
    public Edge(Integer source, Integer target, Double value) {
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
    public Double getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    @JsonProperty("value")
    public void setValue(Double value) {
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
        if ((other instanceof Edge) == false) {
            return false;
        }
        Edge rhs = ((Edge) other);
        return new EqualsBuilder().append(source, rhs.source).append(target, rhs.target).append(value, rhs.value).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

	public Double weight() {
		// TODO Auto-generated method stub
		return getValue();
	}

	public int to() {
		// TODO Auto-generated method stub
		return getTarget();
	}

	public int from() {
		// TODO Auto-generated method stub
		return getSource();
	}
	
	public Edge(Node startNode, Node targetNode, Double value) {
		super();
		this.value = value;
		this.startNode = startNode;
		this.targetNode = targetNode;
	}

	public Node getStartNode() {
		return startNode;
	}

	public void setStartNode(Node startNode) {
		this.startNode = startNode;
	}

	public Node getTargetNode() {
		return targetNode;
	}

	public void setTargetNode(Node targetNode) {
		this.targetNode = targetNode;
	}

}
