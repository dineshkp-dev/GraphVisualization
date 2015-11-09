
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
import com.graphvisual.myApp.algorithm.Bag;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "nodes",
    "links"
})
public class SimpleGraph implements Serializable{

    @JsonProperty("nodes")
    private List<Node> nodes = new ArrayList<Node>();
    @JsonProperty("links")
    private List<Edge> links = new ArrayList<Edge>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private int numOfNodes = 0;                 // number of vertices in this digraph
//    private List<Edge>[] adj;				    // adj[v] = adjacency list for vertex v
    private Bag<Edge>[] adj;

    /**
     * No args constructor for use in serialization
     * 
     */
    private SimpleGraph() {
    }

    /**
     * 
     * @param nodes
     * @param links
     */
    public SimpleGraph(List<Node> nodes, List<Edge> links) {
        this.nodes = nodes;
        this.numOfNodes = nodes.size();
        this.links = links;
    }

    /**
     * 
     * @return
     *     The nodes
     */
    @JsonProperty("nodes")
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * 
     * @param nodes
     *     The nodes
     */
    @JsonProperty("nodes")
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * 
     * @return
     *     The links
     */
    @JsonProperty("links")
    public List<Edge> getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The links
     */
    @JsonProperty("links")
    public void setLinks(List<Edge> links) {
        this.links = links;
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
        return new HashCodeBuilder().append(nodes).append(links).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SimpleGraph) == false) {
            return false;
        }
        SimpleGraph rhs = ((SimpleGraph) other);
        return new EqualsBuilder().append(nodes, rhs.nodes).append(links, rhs.links).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

	public List<Edge> edges() {
		// TODO Auto-generated method stub
		return getLinks();
	}

	public int V() {
		// TODO Auto-generated method stub
		return numOfNodes;
	}

	public Object adj(int v) {
		// TODO Auto-generated method stub
		return null;
	}

}
