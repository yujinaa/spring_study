
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 구글 오픈 api이용해서 차트사용 -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> 
<script type="text/javascript">
   google.charts.load('current', {'packages' : [ 'bar' ]});
   google.charts.setOnLoadCallback(drawChart);
   function drawChart() {
      data = new google.visualization.DataTable();
      data.addColumn('string', '년도별');
      data.addColumn('number', 'test01');
      data.addColumn('number', 'test02');
      data.addColumn('number', 'test03');
      data.addRow(['1월' ,1000, 895 ,915]);

      options = {
         chart : {
            title : "main title",
            subtitle : 'sub title',
         }
      }
      chart = new google.charts.Bar(document.getElementById('columnchart_material'));
      chart.draw(data, google.charts.Bar.convertOptions(options));
   }
</script>
</head>
<body>
	<div id="columnchart_material"></div>
</body>
</html>