
package com.graphvisual.myApp.jsonGen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "name",
    "group"
})
public class Node implements Serializable, Comparable<Node> {

    @JsonProperty("name")
    private String name;
    @JsonProperty("group")
    private Integer group;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonIgnore
    private double minDistance = Double.MAX_VALUE;
    @JsonIgnore
    private List<Edge> adjacenciesList;
    @JsonIgnore
    private boolean visited;
    @JsonIgnore
    private Node prevNode;
    public void setAdjacenciesList(List<Edge> adjacenciesList) {
		this.adjacenciesList = adjacenciesList;
	}

	/**
     * No args constructor for use in serialization
     * 
     */
    public Node() {
    }
    
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public void addNeighbour(Edge edge) {
		this.adjacenciesList.add(edge);
	}
	
	public void setPrevNode(Node prevNode) {
		this.prevNode = prevNode;
	}

    public Node getPrevNode() {
		return prevNode;
	}

	/**
     * 
     * @param name
     * @param group
     */
    public Node(String name, Integer group) {
        this.name = name;
        this.group = group;
        this.adjacenciesList = new ArrayList<Edge>();
    }

    public double getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	/**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The group
     */
    @JsonProperty("group")
    public Integer getGroup() {
        return group;
    }

    /**
     * 
     * @param group
     *     The group
     */
    @JsonProperty("group")
    public void setGroup(Integer group) {
        this.group = group;
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
        return new HashCodeBuilder().append(name).append(group).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Node) == false) {
            return false;
        }
        Node rhs = ((Node) other);
        return new EqualsBuilder().append(name, rhs.name).append(group, rhs.group).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

	public void setMinDistance(int minDistance) {
		this.minDistance = minDistance;
	}

	@Override
	public int compareTo(Node otherNode) {
		return Double.compare(this.minDistance, otherNode.minDistance);
	}

	public List<Edge> getAdjacenciesList() {
		return adjacenciesList;
	}

}
