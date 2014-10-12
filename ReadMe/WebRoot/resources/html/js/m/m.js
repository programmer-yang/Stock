if(typeof(os) == "undefined"){os = {};}
os.mp={
	"broW" : 0,
	"broH" : 0,
	"menu_main_top" : 0,
	"menu_stock_top" : 0,
	"init" : function(){
		
		
		$(window).scroll(function(){os.mp.hold_scroll_top();});
		
		os.mp.ready_chart();//初始化主页图表
		
	},
	"show" : function()
	{
		alert(os.mp.menu_main_top+":"+os.mp.menu_stock_top);
	},
	"initTop" : function()
	{
		os.mp.menu_main_top = ($("#main_page_box").height()+$("#main_page_box").offset().top);
		os.mp.menu_stock_top = ($("#stock_page_box").height()+$("#stock_page_box").offset().top);
	},
	"hold_scroll_top" : function()
	{
		var win_top = $(window).scrollTop();
		if(win_top<350)
		{
			os.mp.hold_menu_style($("#menu_main"), "active");
		} else if(win_top<os.mp.menu_main_top-200)
		{
			os.mp.hold_menu_style($("#menu_stock"), "active");
		} else if(win_top<os.mp.menu_stock_top-200)
		{
			os.mp.hold_menu_style($("#menu_list"), "active");
		}
	},
	"hold_menu_style" : function(menu1,styleName)
	{
		//menu1.removeClass(styleName);
		$("#menu").find("li").removeClass(styleName);
		menu1.addClass(styleName);
	},
	"ready_chart" : function()
	{
		os.mp.mp_pie("店铺库存",os.data.mp_pie_data);
		os.mp.mp_column("20140909",os.data.mp_column_data);
	},
	"mp_pie" : function (pie_title,pie_data)
	{
		$("#main_pie").highcharts({
			chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false
	        },
	        title: {text: pie_title},
	        tooltip: {pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'},
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
	                    style: {color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'}
	                }
	            }
	        },
	        series: [{
	            type: 'pie',
	            name: '比例 ',
	            data: pie_data
	        }]
		});
	},
	"mp_column" : function(time,column_data)
	{
		$("#main_column").highcharts(
			{
	            chart: {type: 'column'},
	            title: {text: '库存使用情况'},
	            subtitle: {text: time+'：使用最多TOP8'},
	            xAxis: {categories: column_data.names},
	            yAxis: {
	                min: 0,
	                title: {
	                    text: '单位 (公斤)'
	                }
	            },
	            tooltip: {
	                headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	                pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                    '<td style="padding:0"><b>{point.y:.1f} kg</b></td></tr>',
	                footerFormat: '</table>',
	                shared: true,
	                useHTML: true
	            },
	            plotOptions: {
	                column: {pointPadding: 0.2,borderWidth: 0}
	            },
	            series: [{name: '公斤',data: column_data.data}]
	        }
		);
	}
};
os.sp = {
	"init" : function()
	{
		os.sp.stock_table();
		os.sp.sp_line("库存整体趋势图","0905-0911",os.data.sp_line_data.times,os.data.sp_line_data.data);
	},
	"stock_table" : function()
	{
		$("#stock_table").dataTable();
	},
	"sp_line" : function(title,timeString,times,data)
	{
		$("#stock_line").highcharts({
			title: {
                text: title,
                x: -20 //center
            },
            subtitle: {
                text: '数据范围: '+timeString,
                x: -20
            },
            xAxis: {
                categories: times
            },
            yAxis: {
                title: {
                    text: '整体库存使用记录(公斤)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: ' kg'
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: 'All',
                data: data
            }]
		});
	}
};



