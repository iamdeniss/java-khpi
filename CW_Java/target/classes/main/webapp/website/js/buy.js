var green = "rgb(10, 206, 24)";

function buy() {
	var imya = function() {
		var im;
		var rowLength = $('.color_table tr:last').index() + 1;
		for(var i = 0; i < rowLength; i++)
		{
			if(($(".color_table tr").eq(i).find("td").eq(4).css("background-color"))==green)
			{
				im = $(".color_table tr").eq(i).find("td").eq(0).text();
				break;
			}
		}
		return im;
	};
	var cena = function() {
		var cen;
		var rowLength = $('.color_table tr:last').index() + 1;
		for(var i = 0; i < rowLength; i++)
		{
			if(($(".color_table tr").eq(i).find("td").eq(4).css("background-color"))==green)
			{
				cen = $(".color_table tr").eq(i).find("td").eq(2).text();
				break;
			}
		}
		return cen;
	};
	$.ajax({
		url: "/coffeelover/addToBasket.do",
		data: {name: imya, price: cena},
		type: 'POST',
		async: false,
		success: function (data) {
			alert(data);
		}
	});
}