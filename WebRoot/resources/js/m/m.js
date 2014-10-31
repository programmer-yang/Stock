if(typeof(os) == "undefined"){os = {};}
os.data = {
	"obj1" : null,
	"obj2" : null,
	"obj3" : null,
	"n1" : 0,
	"n2" : 0,
	"n3" : 0,
	"d" : 
	{
		"mp" : {
			"msimgs" : {
				"img1":"img1.jpg","img2":"img2.jpg","img3":"img3.jpg"
			}
		}
	},
	"clear" : function()
	{
		os.obj1 = null;
		os.obj2 = null;
		os.obj3 = null;
		os.n1 = 0;
		os.n2 = 0;
		os.n3 = 0;
	},
	"mp_pie_data" : [
        ['剩余',   15.5],
        {
            name: '使用',
            y: 84.5,
            sliced: true,
            selected: true
        }
    ],
    "mp_column_data" : {
    	"names" : ['土豆','白菜','青椒','胡萝卜','大蒜','姜','猪肉','羊肉'],
    	"data" : [49.9, 37.2, 31.5, 26.2, 23, 19.5, 18, 16]
    },
    "sp_line_data" : {
    	"times" : ['09-05', '09-06', '09-07', '09-08', '09-09', '09-10','09-11'],
    	"data" : [46, 35.5, 52, 57.5, 28.7, 37.5, 45.8]
    }
		
};
os.lp = {
	//登陆页面JS	
	
};
os.mp = {
	"test" : function(){
		
	},
	//主页页面JS
	"init" : function(){
		os.mp.main.init();//主页信息加载
		os.mp.scroll.init();//必须在主页信息加载之后，因为主页菜单加载问题
		os.mp.stock.init();//初始化库存页面内容，局部加载时控制此处即可
		
	},
	"scroll" : {
		//scroll begin
		"menu_main_top" : 0,
		"menu_stock_top" : 0,
		"menu_list_top" : 0,
		"divs" : [
		          {"name":"main_page_box","menu":"menu_main","height":0,"ready":0,"show":function(){alert(1);}},
		          {"name":"stock_page_box","menu":"menu_stock","height":0,"ready":0,"show":function(){alert(2);}},
		          {"name":"list_page_box","menu":"menu_list","height":0,"ready":0,"show":function(){alert(3);}}
		          ],
		"test" : function(){
			
			
		},
		"init" : function(){
			os.mp.scroll.getHeight();//获取各div高度
			$(window).scroll(function(){os.mp.scroll.hold_scroll_top();});//绑定滚动条事件
		},
		"getHeight" : function(){
			$.each(os.mp.scroll.divs,function(n,div){
				var o =$("#"+div.name);
				div.height = o.height()+o.offset().top;
			});
		},
		"hold_scroll_top" : function(){
			var win_top = $(window).scrollTop();
			for(var i=0;i<os.mp.scroll.divs.length;i++)
			{
				var div = os.mp.scroll.divs[i];
				var o =$("#"+div.menu);
				if(win_top<=div.height-100){
					if(div.ready==0){
						div.ready = 1;
						os.mp.scroll.hold_menu_style(o, "active",i);
//						div.show();
					}
					return;
				}
			}
		},
		"hold_menu_style" : function(menu1,styleName,number)
		{
			$("#content_menu").find("li").removeClass(styleName);
			menu1.addClass(styleName);
			for(var i=0;i<os.mp.scroll.divs.length;i++)
			{
				if(i!=number)
				{
					os.mp.scroll.divs[i].ready = 0;
				}
			}
			
		}
		
		//scroll  end
	},
	"menu" : {
		"init" : function(){
			
		},
		"check_add_data" : function(){
			
		},
		"load_content" : function(){
			$("#add_data_page").load("main/data/load/content",function(){
				$("#add_data_page").modal();
				//backdrop keyboard
			});
		}
	},
	"main" : {
		//main begin
		"init" : function(){
			os.mp.main.load_menus();//加载主页菜单内容
			os.mp.main.ready_chart();//初始化图表内容
			
			os.mp.main.test();
		},
		"test" : function(){
			
//			$.ajax({
//				type:"post",
//				url:"main/pie_data",
//				contentType: "application/json; charset=utf-8",
//				success:function(data)
//				{
//					alert("ok");
//					//alert(typeof(data));
//				},
//				error:function(XMLHttpRequest, textStatus, errorThrown)
//				{
//					alert("no");
//					alert(errorThrown);
//				}
//				
//			});
//			
//			alert(os.mp.main.get_pie_data("15.5","84.5"));
		},
		"load_menus" : function(){
			$("#content_menu").load("main/load/menu");//回调函数未实现高度刷新，待需要时再实现。
		},
		"ready_chart" : function()
		{
			$("#main_page_box").load("main/load/page",function(){
				os.mp.main.ready_chart_pie();
				os.mp.main.ready_chart_column();
				//os.mp.main.mp_column("20140909",os.data.mp_column_data);
			});
		},
		"ready_chart_pie" : function()
		{
			$.ajax({
				type:"post",
				url:"main/ajax/pie/data",
				contentType: "application/json; charset=utf-8",
				success:function(data)
				{
					var jsonData = null;
					var piedata = null;
					os.mp.scroll.getHeight();//内容加载后获取各DIV高度
					jsonData= $.parseJSON(data);
					piedata =  [['剩余',parseFloat(jsonData.sur)],{name: '使用',y: parseFloat(jsonData.use),sliced: true,selected: true}];
					os.mp.main.mp_pie("店铺库存",piedata);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown)
				{
					//异常情况，待完善
					alert("no");
					//alert(errorThrown);
				}
				
			});
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
		"ready_chart_column" : function(){
			$.ajax({
				type:"post",
				url:"main/ajax/column/data",
				contentType: "application/json; charset=utf-8",
				success:function(data)
				{
					var columnData = os.mp.main.trim_column_json($.parseJSON(data));
					os.mp.main.mp_column("20140909",columnData);
					
				},
				error:function(XMLHttpRequest, textStatus, errorThrown)
				{
					//异常情况，待完善
					alert("no");
					//alert(errorThrown);
				}
				
			});
		},
		"trim_column_json" : function(columnJson)
		{
			var columnData = {};
			columnData.names = [];
			columnData.data = [];
			var i = 0;
			for(var o in columnJson)
			{
				var key = o;
				var value = columnJson[o];
				columnData.names[i] = key;
				columnData.data[i] = parseFloat(value);
				i++;
			}
			return columnData;
			
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
		
		//main end
	},
	"stock" : {
		//stock begin
		"init" : function()
		{
			os.mp.stock.stock_table();
			os.mp.stock.sp_line("库存整体趋势图","0905-0911",os.data.sp_line_data.times,os.data.sp_line_data.data);
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
		
		
		//stock end
	}
		
};
