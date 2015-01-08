if (typeof(os) == "undefined") {
    os = {};
}
os.show = function(str){console.log(str);}
os.data = {
    obj1: null, obj2: null, obj3: null, n1: 0, n2: 0, n3: 0,
    clear: function () {
        os.obj1 = null;
        os.obj2 = null;
        os.obj3 = null;
        os.n1 = 0;
        os.n2 = 0;
        os.n3 = 0;
    },
    mp_pie_data: [
        ['剩余', 15.5],
        {
            name: '使用',
            y: 84.5,
            sliced: true,
            selected: true
        }
    ],
    mp_column_data: {
        names: ['土豆', '白菜', '青椒', '胡萝卜', '大蒜', '姜', '猪肉', '羊肉'],
        data: [49.9, 37.2, 31.5, 26.2, 23, 19.5, 18, 16]
    },
    sp_line_data: {
        times: ['09-05', '09-06', '09-07', '09-08', '09-09', '09-10', '09-11'],
        data: [46, 35.5, 52, 57.5, 28.7, 37.5, 45.8]
    },
    add_data: {
        autocomplete: [
            {name: 'PHP', id: '1'},
            {name: 'MySQL', id: '2'},
            {name: '白菜', id: '3'},
            {name: '白菜2', id: '3'},
            {name: '白菜3', id: '3'}
        ]
    }


};
os.action = function(str,para,o){
	os.show(str+":"+para+":"+o+":"+event);
	var patrn = /(^([\w_]{1,})$)/;
	if(!patrn.exec(str))
		return;
//	if(str == 'add_data_select_page')
//	{
//		os.mp.top.data.select_page(para);
//	}
	switch(str)
	{
		case 'add_data_select_page' :
			os.mp.top.data.select_page(para);
			break;
		case 'save_stock_log_use' :
			os.mp.top.submit_form_use(para,o,event);
			break;
		default:
			break;
	}
}
os.tool = {
    autocomplete: {//自动补全事件实现控制,待添加动态数据模块,既添加一个参数
        defaultPara: {
        	patrn: /[^(\u4e00-\u9fa5\w)]/,
        	source: function (query, process) {
        		var newArray = [];
        		var data = os.tool.autocomplete.defaultPara.curData;
        		
        		if (os.tool.autocomplete.defaultPara.patrn.exec(query)) {
        			return;
        		}
        		for (var i = 0; i < data.length; i++) {
        			if (query == '' || data[i].name.toLowerCase().indexOf(query) >= 0 || data[i].id.indexOf(query) >= 0) {
        				newArray.push(data[i]);
        			}
        		}
        		return newArray;
        	},
        	formatItem: function (item) {
        		return item.name;
        	},
        	setValue: function (item) {
        		return {'data-value': item.name, 'real-value': item.id}
//        		return {'data-value': item.name, 'value': item.id}
        	},
        	updater: function (item,value){
        		//选中补全内容后执行
        		//这里需要考虑实现一个具体实现方法
//        		os.show(item+":"+value);
        		os.mp.top.data.ready_line(item);
        		return item;
        	},
        	curData:[]
        
        },
        init: function(newPara) {
        	/**
        	 * 这里预留一个问题
        	 * 目前这里的实现想法是实现一个自动补全功能实现参数模板
        	 * 但如果一个页面有多个自动补全功能,这就涉及到现有参数列表中的curData会公用
        	 * 如果这样,是否存在参数异常情况,需要以后测试,如果有,需要想解决办法
        	 */
        	os.tool.autocomplete.defaultPara.curData= newPara;
        	return os.tool.autocomplete.defaultPara;
        }
    },
    myAjax: function(path,suc) {
    	$.ajax({
            type: 'post',
            url: path,
            contentType: 'application/json; charset=utf-8',
            success: suc,
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                //异常情况，待完善
                alert('no');
                //alert(errorThrown);
            }

        });
    },
    datetimepicker: function(name) {
    	 $('#'+name).datetimepicker({
             language:  'zh-CN',
             weekStart: 1,
             todayBtn:  1,
     		autoclose: 1,
     		todayHighlight: 1,
     		startView: 2,
     		minView: 2,
     		forceParse: 0
         });
    }
}

os.lp = {
    //登陆页面JS

};
os.mp = {
    'test': function () {

    },
    //主页页面JS
    init: function () {
        os.mp.main.init();//主页信息加载
        os.mp.scroll.init();//必须在主页信息加载之后，因为主页菜单加载问题
        os.mp.stock.init();//初始化库存页面内容，局部加载时控制此处即可

    },
    scroll: {
        //scroll begin
        menu_main_top: 0,
        menu_stock_top: 0,
        menu_list_top: 0,
        divs: [
            {name: 'main_page_box', menu: 'menu_main', height: 0, ready: 0, show: function () {
                alert(1);
            }},
            {name: 'stock_page_box', menu: 'menu_stock', height: 0, ready: 0, show: function () {
                alert(2);
            }},
            {name: 'list_page_box', menu: 'menu_list', height: 0, ready: 0, show: function () {
                alert(3);
            }}
        ],
        test: function () {


        },
        init: function () {
            os.mp.scroll.getHeight();//获取各div高度
            $(window).scroll(function () {
                os.mp.scroll.hold_scroll_top();
            });//绑定滚动条事件
        },
        getHeight: function () {
            $.each(os.mp.scroll.divs, function (n, div) {
                var o = $('#' + div.name);
                div.height = o.height() + o.offset().top;
            });
        },
        hold_scroll_top: function () {
            var win_top = $(window).scrollTop();
            for (var i = 0; i < os.mp.scroll.divs.length; i++) {
                var div = os.mp.scroll.divs[i];
                var o = $('#' + div.menu);
                if (win_top <= div.height - 100) {
                    if (div.ready == 0) {
                        div.ready = 1;
                        os.mp.scroll.hold_menu_style(o, 'active', i);
//						div.show();
                    }
                    return;
                }
            }
        },
        hold_menu_style: function (menu1, styleName, number) {
            $('#content_menu').find('li').removeClass(styleName);
            menu1.addClass(styleName);
            for (var i = 0; i < os.mp.scroll.divs.length; i++) {
                if (i != number) {
                    os.mp.scroll.divs[i].ready = 0;
                }
            }

        }

        //scroll  end
    },
    top: {
        test: function (useForm,o,e) {
        	os.show("Good morning Yang");
//        	e.preventDefault();
//        	var l = Ladda.create(o);
//    	 	l.start();
//    	 	
//        	$.ajax({
//        		cache: true,
//        		type: "POST",
//        		url: useForm.action,
//        		data: $(useForm).serialize(),
//        		async: false,
//        		error: function(request){
//        			os.show("errrrrrrrrrrrrrrrrrrrrrrrrrrrro");
////        			l.stop();
//        		},
//        		success: function(){
////        			l.stop();
//        			os.show("submit is ok");
//        		}
//    		});
        	
        	os.show("message is here");
        	$._messengerDefaults = {
        			extraClasses: 'messenger-fixed messenger-theme-flat messenger-on-bottom'
        		}
        	
        	$.globalMessenger().post("Your request has succeded!");
        	
        	
        },
        data: {
            init: function () {
            	//os.mp.top.data.update_data();
            	
            	
            	os.mp.top.data.load_data();//加载添加数据区域内容
            	
            	
            },
            select_page: function (name) {
            	//添加数据页面功能选择(日消耗,进货)页面切换
            	var useSelect = $('#add_data_select_use');
            	var useContent = $('#add_data_content_use');
            	var addSelect = $('#add_data_select_add');
            	var addContent = $('#add_data_content_add');
            	switch (name) {
				case 'use':
					if(useSelect.hasClass('active'))
						return;
					addSelect.removeClass('active');
					useSelect.addClass('active');
					addContent.addClass('hide');
					useContent.removeClass('hide');
					break;
				case 'add':
					if(addSelect.hasClass('active'))
						return;
					useSelect.removeClass('active');
					addSelect.addClass('active');
					useContent.addClass('hide');
					addContent.removeClass('hide');
					break;
				default:
					break;
				}
            },
            load_data: function () {
                $('#add_data_page').load('data/add/load/content', function () {
                	
                    $('#add_data_page').modal();//是否能添加回调函数,待调研
                    //加载按钮提交动画
                    os.mp.top.data.load_but_animate();
                    
                    //准备补全事件数据
                    $.when(os.mp.top.data.update_data()).then(function(){
                    	//在获取当前用户可用数据后加载补全事件
                    	//库存类型自动补全事件
                        os.mp.top.data.load_stock_names();
                        
                    },function(){
                    	console.log('加载补全事件出错了');
                    });
                    
                    //首先添加曲线图数据
                    //这里首次添加内容还需要考虑
//                    os.mp.top.data.load_line('测试类型', '0905-0911', os.data.sp_line_data.times, os.data.sp_line_data.data);
                    
                    //加载添加数据内容区域完毕后加载时间控件
                    os.tool.datetimepicker('datetimepicker1');
                });
            },
            ready_line: function(name){
            	//根据选中的name获取对应的数据
            	//目前是临时实现,需要重写,重写后删除此行
            	os.mp.top.data.load_line('测试类型', '0905-0911', os.data.sp_line_data.times, os.data.sp_line_data.data);
            },
            load_line: function (title, timeString, times, data) {
                $('#add_line').highcharts({
                    title: {
                        text: title,
                        x: -20 //center
                    },
                    subtitle: {
                        text: '数据范围: ' + timeString,
                        x: -20
                    },
                    xAxis: {
                        categories: times
                    },
                    yAxis: {
                        title: {
                            text: '整体库存使用记录(公斤)'
                        },
                        plotLines: [
                            {
                                value: 0,
                                width: 1,
                                color: '#808080'
                            }
                        ]
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
                    series: [
                        {
                            name: 'All',
                            data: data
                        }
                    ]
                });
            },
            load_stock_names: function () {
            	//绑定自动补全事件
//            	console.log('get');
//            	console.log(os.data.add_data.autocomplete);
            	$('#useStockName').autocomplete(os.tool.autocomplete.init(os.data.add_data.autocomplete));

            },
            update_data: function () {/*更新所需数据*/
            	var dtd = $.Deferred();
            	
            	//动态获取当前用户可用货物名称
            	os.tool.myAjax('data/ajax/user/stockname',function(data){
            		os.mp.top.trim(data,dtd);
            	});
            	return dtd.promise();
            },
            load_but_animate: function(){
            	//加载按钮动画事件
            	//Ladda.bind( '.ladda-mark button', { timeout: 2000 } );
            	
            }
        },
        trim: function(data,dtd) {
        	var jsonData =  $.parseJSON(data);
        	var stockNames = [];
        	var i = 0;
        	for(var o in jsonData){
        		var names = {};
        		names.id = o;
        		names.name = jsonData[o];
        		stockNames[i] = names;
        		i++;
        	}
        	if(stockNames.length>0)
        		os.data.add_data.autocomplete = stockNames;
        	dtd.resolve();
        },
        submit_form_use:function(useForm,o,e)
        {
        	e.preventDefault();
        	
        	var l = Ladda.create(o);
        	l.start();
    	 	
        	
    	 	//这里存在问题,改变元素的value,会改变现实的值,是否需要添加一个参数传递这个id?
    	 	////...................
    	 	var stockName = useForm.useStockName;
        	useForm.useStockName.value = $(stockName).attr('real-value');
        	
        	
        	
        	//坑爹的异步?????///................................
        	$.ajax({
	        		cache: true,
	        		type: "POST",
	        		url: useForm.action,
	        		data: $(useForm).serialize(),
	        		async: false,
	        		error: function(request){
	        			os.show("errrrrrrrrrrrrrrrrrrrrrrrrrrrro");
//	        			l.stop();
	        		},
	        		success: function(){
//	        			l.stop();
	        			os.show("submit is ok");
	        		}
        		});
        	
        	
        	
        }
    },
    main: {
        //main begin
        init: function () {
            os.mp.main.load_menus();//加载主页菜单内容
            os.mp.main.ready_chart();//初始化图表内容

            os.mp.main.test();
        },
        test: function () {
            //.....
        },
        load_menus: function () {
            $('#content_menu').load('main/load/menu');//回调函数未实现高度刷新，待需要时再实现。
        },
        ready_chart: function () {
            $('#main_page_box').load('main/load/page', function () {
                os.mp.main.ready_chart_pie();
                os.mp.main.ready_chart_column();
                //os.mp.main.mp_column("20140909",os.data.mp_column_data);
            });
        },
        ready_chart_pie: function () {
            $.ajax({
                type: 'post',
                url: 'main/ajax/pie/data',
                contentType: 'application/json; charset=utf-8',
                success: function (data) {
                    var jsonData = null;
                    var piedata = null;
                    os.mp.scroll.getHeight();//内容加载后获取各DIV高度
                    jsonData = $.parseJSON(data);
                    piedata = [
                        ['剩余', parseFloat(jsonData.sur)],
                        {name: '使用', y: parseFloat(jsonData.use), sliced: true, selected: true}
                    ];
                    os.mp.main.mp_pie('店铺库存', piedata);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    //异常情况，待完善
                    alert('no');
                    //alert(errorThrown);
                }

            });
        },
        mp_pie: function (pie_title, pie_data) {
            $('#main_pie').highcharts({
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
                series: [
                    {
                        type: 'pie',
                        name: '比例 ',
                        data: pie_data
                    }
                ]
            });
        },
        ready_chart_column: function () {
            $.ajax({
                type: 'post',
                url: 'main/ajax/column/data',
                contentType: 'application/json; charset=utf-8',
                success: function (data) {
                    var columnData = os.mp.main.trim_column_json($.parseJSON(data));
                    os.mp.main.mp_column('20140909', columnData);

                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    //异常情况，待完善
                    alert('no');
                    //alert(errorThrown);
                }

            });
        },
        trim_column_json: function (columnJson) {
            var columnData = {};
            columnData.names = [];
            columnData.data = [];
            var i = 0;
            for (var o in columnJson) {
                var key = o;
                var value = columnJson[o];
                columnData.names[i] = key;
                columnData.data[i] = parseFloat(value);
                i++;
            }
            return columnData;

        },
        mp_column: function (time, column_data) {
            $('#main_column').highcharts(
                {
                    chart: {type: 'column'},
                    title: {text: '库存使用情况'},
                    subtitle: {text: time + '：使用最多TOP8'},
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
                        column: {pointPadding: 0.2, borderWidth: 0}
                    },
                    series: [
                        {name: '公斤', data: column_data.data}
                    ]
                }
            );
        }
        //main end
    },
    stock: {
        //stock begin
        init: function () {
            os.mp.stock.stock_table();
            os.mp.stock.sp_line('库存整体趋势图', '0905-0911', os.data.sp_line_data.times, os.data.sp_line_data.data);
        },
        stock_table: function () {
            $('#stock_table').dataTable();
        },
        sp_line: function (title, timeString, times, data) {
            $('#stock_line').highcharts({
                title: {
                    text: title,
                    x: -20 //center
                },
                subtitle: {
                    text: '数据范围: ' + timeString,
                    x: -20
                },
                xAxis: {
                    categories: times
                },
                yAxis: {
                    title: {
                        text: '整体库存使用记录(公斤)'
                    },
                    plotLines: [
                        {
                            value: 0,
                            width: 1,
                            color: '#808080'
                        }
                    ]
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
                series: [
                    {
                        name: 'All',
                        data: data
                    }
                ]
            });
        }


        //stock end
    }

};
