$(document).ready(function() {
	$("#translate").click(function() {
		var txt = $("#srctext").val();
		if (txt.trim().length > 0) {
			$.post("translate", {
				text : txt
			}, function(result) {
				var d = result.data;
				d = d.replace(/"/g, '');
				$("#show").text(d);
			});

		} else {
			$("#show").text('请输入值');
		}
	});
	$("#test").click(function() {
		$.ajax("example.php").done(function() {
			alert("success");
		}).fail(function(req) {
			alert("error");
		});
	});
})