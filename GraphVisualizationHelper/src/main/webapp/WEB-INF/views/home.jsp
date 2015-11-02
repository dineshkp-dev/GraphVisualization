<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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

.node.fixed {
	fill: #f00;
}
</style>
</head>
<body>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.5/d3.min.js"></script>
	<h1>Graph Visualizer</h1>

	<P>The time on the server is ${serverTime}.</P>
	<p>Displaying Graph:</p>
	<script>
		var width = 960, height = 500;
		var color = d3.scale.category20();
		var force = d3.layout.force().charge(-500).linkDistance(function(d) {
			return (d.value * 20);
		}).size([ width, height ]).on("tick", tick); 
		var drag = force.drag().on("dragstart", dragstart);
		var svg = d3.select("body").append("svg").attr("width", width).attr(
				"height", height);
		var link = svg.selectAll(".link"), node = svg.selectAll(".node");
		var gnodes = svg.selectAll('g.node');

		d3.json("${pageContext.request.contextPath}/filerequest", function(
				error, graph) {
			if (error)
				throw error;

			force.nodes(graph.nodes).links(graph.links).start();

			link = link.data(graph.links).enter().append("line").attr("class",
					"link").style("stroke-width", function(d) {
				return Math.sqrt(d.value);
			});
			gnodes = gnodes.data(graph.nodes).enter().append('g').classed(
					'gnode', true).on("dblclick", dblclick).call(force.drag);

			node = gnodes.append("circle").attr("class", "node").attr("r", 12)
					.style("fill", function(d) {
						return color(d.group);
					});
			var labels = gnodes.append("text").text(function(d) {
				return d.name;
			});
		});

		function tick() {
			// Update the links
			link.attr("x1", function(d) {
				return d.source.x;
			}).attr("y1", function(d) {
				return d.source.y;
			}).attr("x2", function(d) {
				return d.target.x;
			}).attr("y2", function(d) {
				return d.target.y;
			});
			gnodes.attr("transform", function(d) {
				return 'translate(' + [ d.x, d.y ] + ')';
			});

		}

		function dblclick(d) {
			d3.select(this).classed("fixed", d.fixed = false);
		}
		function dragstart(d) {
			d3.select(this).classed("fixed", d.fixed = true);
		}
	</script>

</body>
</html>
