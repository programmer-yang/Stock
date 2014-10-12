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
