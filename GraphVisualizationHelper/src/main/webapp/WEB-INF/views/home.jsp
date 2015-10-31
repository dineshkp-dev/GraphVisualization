<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>my App</title>
	<meta charset="utf-8">
	<style>
	
	.node {
	  stroke: #fff;
	  stroke-width: 1.5px;
	}
	
	.link {
	  stroke: #999;
	  stroke-opacity: .6;
	}
	
	</style>
</head>
<body>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.5/d3.min.js"></script>
	<h1>
		Graph Visualizer
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	<p>Displaying Graph:</p>
	<script>
	
	var width = 960,
	    height = 500;
	
	var color = d3.scale.category20();
	
	var force = d3.layout.force()
	    .charge(0)
	    .linkDistance(function(d) { return (d.value * 20); })
	    .size([width, height]);
	
	var svg = d3.select("body").append("svg")
	    .attr("width", width)
	    .attr("height", height);
	
	d3.json("${pageContext.request.contextPath}/filerequest", function(error, graph) {
	  if (error) throw error;
	
	  force
	      .nodes(graph.nodes)
	      .links(graph.links)
	      .start();
	
	  var link = svg.selectAll(".link")
	      .data(graph.links)
	      .enter().append("line")
	      .attr("class", "link")
	      .style("stroke-width", function(d) { return Math.sqrt(d.value); })
	      .call(force.drag);
	
	  var node = svg.selectAll(".node")
	      .data(graph.nodes)
	    .enter().append("circle")
	      .attr("class", "node")
	      .attr("r", 5)
	      .style("fill", function(d) { return color(d.group); })
	      .call(force.drag);
	
	  node.append("title")
	      .text(function(d) { return d.name; });
	
	  force.on("tick", function() {
	    link.attr("x1", function(d) { return d.source.x; })
	        .attr("y1", function(d) { return d.source.y; })
	        .attr("x2", function(d) { return d.target.x; })
	        .attr("y2", function(d) { return d.target.y; });
	
	    node.attr("cx", function(d) { return d.x; })
	        .attr("cy", function(d) { return d.y; });
	  });
	});
	
	</script>

</body>
</html>
