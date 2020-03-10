/** layuiAdmin.std-v2020.1.24 LPPL License By https://www.layui.com/admin/ */

;layui.define( function(e){
        layui.use(["admin","carousel"],function(){
            var e=layui.$
                ,a=(layui.admin,layui.carousel)
                ,t=layui.element
                ,i=layui.device();
            e(".layadmin-carousel").each(function(){
                var t=e(this);
                a.render({
                        elem:this,
                        width:"100%",
                        arrow:"none",
                        interval:t.data("interval"),
                        autoplay:t.data("autoplay")===!0,
                        trigger:i.ios||i.android?"click":"hover",
                        anim:t.data("anim")
                    })
            }),
            t.render("progress")
        }),

        console.log("11111");
         //line.html
        layui.use(["carousel","echarts","jquery"],function(){
            var e=layui.$,
                a=(layui.carousel,layui.echarts),
                $=layui.jquery,
                t=[],//mychart
                i=[{ //option
                   // title:{text:"未来一周气温变化",subtext:"纯属虚构"},
                    tooltip:{trigger:"axis"},
                    legend:{data:["软件学院","计算机学院","外国语学院","材料学院"]},
                    calculable:!0,
                    xAxis:[{
                        type:"category",
                        boundaryGap:!1,
                        data:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
                    }],
                    yAxis:[{
                        type:"value",
                        //axisLabel:{formatter:"{value} °C"}
                    }],
                     series:[
                         {
                             name:"软件学院",type:"line",stack:"总量",
                             data:[]
                         },
                         {
                             name:"计算机学院",type:"line",stack:"总量",
                             data:[]
                         },
                         {
                             name:"外国语学院",type:"line",stack:"总量",
                            data:[]
                         },
                         {
                             name:"材料学院",type:"line",stack:"总量",
                             data:[]
                         },
                     ]
                }],
                n=e("#LAY-index-heapline").children("div"),
                l=function(e){
                    t[e]=a.init(n[e],layui.echartsTheme)
                    var arr = new Array();    //类别数组（实际用来盛放X轴坐标值）
                    $.ajax({
                        type : "get",
                        async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                        url : "/consumption",
                        dataType : "json",
                        success : function(data) {
                            //请求成功时执行该函数内容，result即为服务器返回的json对象
                            console.log("333")
                            if (data.type == "consumption") {
                                console.log("444")
                                var obj =eval(data.obj);//解析后台传来的json数据,是一个二维数组
                                console.log(obj)
                                console.log("555")
                                console.log(obj[0][1].data)
                                var ly =obj[0][1].data;//得到data数组

                               for(var w = 0;w< ly.length;w++){
                                   arr[w]=new Array();
                                   for (var j=0;j< ly[w].length;j++){
                                       console.log(ly[w][j]);
                                       arr[w][j]=ly[w][j];

                                   }

                               }
                              // console.log(arr)
                                // console.log(data.obj[0][1].data);
                                // for (var i = 0; i < data.obj[0][1].data[0].length; i++) {
                                //     names.push(data.obj[0][1].data[0][i]);
                                // }
                              //  print(names);
                                // for (var i = 0; i < obj.length; i++) {
                                //     nums.push(obj[i].num);
                                // }
                                t[e].hideLoading(); //隐藏加载动画
                                console.log("666")
                                console.log(arr[0])
                               // nums.push(arr[0]);
                                t[e].setOption({ //加载数据图表
                                    tooltip:{trigger:"axis"},
                                    legend:{data:["软件学院","计算机学院","外国语学院","材料学院"]},
                                    calculable:!0,
                                    xAxis:[{
                                        type:"category",
                                        boundaryGap:!1,
                                        data:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
                                    }],
                                    yAxis:[{
                                        type:"value",
                                        //axisLabel:{formatter:"{value} °C"}
                                    }],
                                    series:[
                                        {
                                            name:"软件学院",type:"line",stack:"总量",
                                            data:arr[0]
                                        },
                                        {
                                            name:"计算机学院",type:"line",stack:"总量",
                                            data:arr[1]
                                        },
                                        {
                                            name:"外国语学院",type:"line",stack:"总量",
                                            data:arr[2]
                                        },
                                        {
                                            name:"材料学院",type:"line",stack:"总量",
                                            data:arr[3]
                                        },
                                    ]
                                });
                                console.log("777")
                            }else{
                                alert("后台数据获取失败!");
                            }
                        },
                        error : function(errorMsg) {
                            //请求失败时执行该函数
                            console.log(errorMsg);
                            alert("图表请求数据失败!");
                           // t[e].hideLoading();
                        }
                    });

                   console.log("888")
                    t[e].setOption(i[e]),
                    window.onresize=t[e].resize
                };
                if(n[0]){l(0);
                    var r=[],
                    o=[
                        {
                            tooltip:{trigger:"axis"},
                            legend:{data:["软件学院","计算机学院","外国语学院","材料学院"]},
                            calculable:!0,
                            xAxis:[{type:"category",boundaryGap:!1,data:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]}],
                            yAxis:[{type:"value"}],
                            series:[
                                {name:"软件学院",type:"line",stack:"总量",data:[]},
                                {name:"计算机学院",type:"line",stack:"总量",data:[]},
                                {name:"外国语学院",type:"line",stack:"总量",data:[]},
                                {name:"材料学院",type:"line",stack:"总量",data:[]},
                                
                                ]
                        }
                    ],
                    m=e("#LAY-index-normline").children("div"),
                    s=function(e){
                        r[e]=a.init(m[e],layui.echartsTheme)

                        var arr = new Array();    //类别数组（实际用来盛放y轴坐标值）
                        $.ajax({
                            type : "get",
                            async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                            url : "/consumption",
                            dataType : "json",
                            success : function(data) {
                                //请求成功时执行该函数内容，result即为服务器返回的json对象
                                if (data.type == "consumption") {
                                    var obj =eval(data.obj);//解析后台传来的json数据,是一个二维数组
                                    var ly =obj[2][1].data;//得到obj的第三行~~data数组
                                    for(var w = 0;w< ly.length;w++){
                                        arr[w]=new Array();
                                        for (var j=0;j< ly[w].length;j++){
                                            arr[w][j]=ly[w][j];
                                        }
                                    }
                                    r[e].hideLoading(); //隐藏加载动画~~
                                    r[e].setOption({ //加载数据图表
                                        tooltip:{trigger:"axis"},
                                        legend:{data:["软件学院","计算机学院","外国语学院","材料学院"]},
                                        calculable:!0,
                                        xAxis:[{type:"category",boundaryGap:!1,data:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]}],
                                        yAxis:[{type:"value"}],
                                        series:[
                                            {name:"软件学院",type:"line",stack:"总量",data:arr[0]},
                                            {name:"计算机学院",type:"line",stack:"总量",data:arr[1]},
                                            {name:"外国语学院",type:"line",stack:"总量",data:arr[2]},
                                            {name:"材料学院",type:"line",stack:"总量",data:arr[3]},

                                        ]
                                    });
                                }else{
                                    alert("后台数据获取失败!");
                                }
                            },
                            error : function(errorMsg) {
                                //请求失败时执行该函数
                                console.log(errorMsg);
                                alert("图表请求数据失败!");
                                // t[e].hideLoading();
                            }
                        });

                        r[e].setOption(o[e]),
                        window.onresize=r[e].resize
                    };
                    // if(m[0]){s(0);

                            if(m[0]){s(0); 
                            var u=[],
                                x=[
                                    {
                                        title:{
                                             text:"消费地点分布",
                                             x:"center",
                                             textStyle:{fontSize:14}
                                        },
                                        tooltip:{
                                            trigger:"item",
                                            formatter:"{a} <br/>{b} : {c} ({d}%)"
                                        },
                                        legend:{
                                            orient:"vertical",
                                            x:"left",
                                            data:["开发区校区食堂","西山热水器","大学生超市","西山浴室","圈存缴网费"]
                                        },
                                        series:[
                                            {
                                                name:"消费地点",
                                                type:"pie",
                                                radius:"55%",
                                                center:["50%","50%"],
                                                data:[
                                                    {value:9052,name:"开发区校区食堂"},
                                                    {value:1610,name:"西山热水器"},
                                                    {value:3200,name:"大学生超市"},
                                                    {value:535,name:"西山浴室"},
                                                    {value:1700,name:"圈存缴网费"}
                                                ]
                                            }
                                        ]

                                    }
                                ],
                                v=e("#LAY-index-heaparea").children("div"),
                                b=function(e){
                                    u[e]=a.init(v[e],layui.echartsTheme)

                                    // var arr = new Array();    //类别数组（实际用来盛放y轴坐标值）
                                    // $.ajax({
                                    //     type : "get",
                                    //     async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                                    //     url : "/consumption",
                                    //     dataType : "json",
                                    //     success : function(data) {
                                    //         //请求成功时执行该函数内容，result即为服务器返回的json对象
                                    //         if (data.type == "consumption") {
                                    //             var obj =eval(data.obj);//解析后台传来的json数据,是一个二维数组
                                    //             var ly =obj[1][1].data;//得到obj的第三行~~data数组
                                    //             for(var w = 0;w< ly.length;w++){
                                    //                 arr[w]=new Array();
                                    //                 for (var j=0;j< ly[w].length;j++){
                                    //                     arr[w][j]=ly[w][j];
                                    //                 }
                                    //             }
                                    //             u[e].hideLoading(); //隐藏加载动画~~
                                    //             u[e].setOption({ //加载数据图表
                                    //                 title:{
                                    //                     text:"消费地点分布",
                                    //                     x:"center",
                                    //                     textStyle:{fontSize:14}
                                    //                 },
                                    //                 tooltip:{
                                    //                     trigger:"item",
                                    //                     formatter:"{a} <br/>{b} : {c} ({d}%)"
                                    //                 },
                                    //                 legend:{
                                    //                     orient:"vertical",
                                    //                     x:"left",
                                    //                     data:["开发区校区食堂","西山热水器","大学生超市","西山浴室","圈存缴网费"]
                                    //                 },
                                    //                 series:[
                                    //                     {
                                    //                         name:"消费地点",
                                    //                         type:"pie",
                                    //                         radius:"55%",
                                    //                         center:["50%","50%"],
                                    //                         data:[
                                    //                             {value:9052,name:"开发区校区食堂"},
                                    //                             {value:1610,name:"西山热水器"},
                                    //                             {value:3200,name:"大学生超市"},
                                    //                             {value:535,name:"西山浴室"},
                                    //                             {value:1700,name:"圈存缴网费"}
                                    //                         ]
                                    //                     }
                                    //                 ]
                                    //             });
                                    //         }else{
                                    //             alert("后台数据获取失败!");
                                    //         }
                                    //     },
                                    //     error : function(errorMsg) {
                                    //         //请求失败时执行该函数
                                    //         console.log(errorMsg);
                                    //         alert("图表请求数据失败!");
                                    //         // t[e].hideLoading();
                                    //     }
                                    // });
                                    u[e].setOption(x[e]),
                                    window.onresize=u[e].resize
                                };

                                v[0]&&b(0)
                            }
                }
        }),

        console.log("111222") ;
               //柱状图bar.html
        layui.use(["carousel","echarts","jquery"],function(){
                var e=layui.$,
                    a=(layui.carousel,layui.echarts),
                    $=layui.jquery,
                    t=[],
                    i=[{
                        tooltip:{trigger:"axis"},
                        legend:{data:["Java","数据结构","计算机组成原理","数据库"]},
                        calculable:!0,
                        xAxis:[{type:"category",data:["软件学院","计算机学院","外国语学院","材料学院","艺术学院"]}],
                        yAxis:[{type:"value"}],
                        series:[
                            {
                                name:"Java",
                                type:"line",
                                // data:[2,4.9,7,23.2,25.6],
                                data:[]
                            },
                            {   name:"数据结构",
                                type:"line",
                                // data:[175.6,182.2,48.7,18.8,6],
                                data:[]
                            },
                            {   name:"计算机组成原理",
                                type:"line",
                                // data:[17,18,48.7,18,62],
                                data:[]
                            },
                            {   name:"数据库",
                                type:"line",
                                // data:[75.6,82.2,8.7,108.8,36],
                                data:[]
                            }
                        ]

                    }],
                    n=e("#LAY-index-normcol").children("div"),
                    l=function(e){
                        t[e]=a.init(n[e],layui.echartsTheme)
                        console.log("1")
                        var arr = new Array();    //类别数组（实际用来盛放X轴坐标值）
                        $.ajax({
                            type : "get",
                            async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                            url : "/study",
                            dataType : "json",
                            success : function(data) {
                                //请求成功时执行该函数内容，result即为服务器返回的json对象
                                console.log("333")
                                if (data.type == "study") {
                                    console.log("444")
                                    var obj =eval(data.obj);//解析后台传来的json数据,是一个二维数组
                                    console.log(obj)
                                    console.log("555")
                                    console.log(obj[0][1].data)
                                    var ly =obj[0][1].data;//得到data数组

                                    for(var w = 0;w< ly.length;w++){
                                        arr[w]=new Array();
                                        for (var j=0;j< ly[w].length;j++){
                                            console.log(ly[w][j]);
                                            arr[w][j]=ly[w][j];

                                        }

                                    }
                                    // console.log(arr)
                                    // console.log(data.obj[0][1].data);
                                    // for (var i = 0; i < data.obj[0][1].data[0].length; i++) {
                                    //     names.push(data.obj[0][1].data[0][i]);
                                    // }
                                    //  print(names);
                                    // for (var i = 0; i < obj.length; i++) {
                                    //     nums.push(obj[i].num);
                                    // }
                                    t[e].hideLoading(); //隐藏加载动画
                                    console.log("666")
                                    console.log(arr[0])
                                    // nums.push(arr[0]);
                                    t[e].setOption({ //加载数据图表
                                        tooltip:{trigger:"axis"},
                                        legend:{data:["Java","数据结构","计算机组成原理","数据库"]},
                                        calculable:!0,
                                        xAxis:[{type:"category",data:["软件学院","计算机学院","外国语学院","材料学院","艺术学院"]}],
                                        yAxis:[{type:"value"}],
                                        series:[
                                            {
                                                name:"Java",
                                                type:"line",
                                                // data:[2,4.9,7,23.2,25.6],
                                                data:arr[0]
                                            },
                                            {   name:"数据结构",
                                                type:"line",
                                                // data:[175.6,182.2,48.7,18.8,6],
                                                data:arr[1]
                                            },
                                            {   name:"计算机组成原理",
                                                type:"line",
                                                // data:[17,18,48.7,18,62],
                                                data:arr[2]
                                            },
                                            {   name:"数据库",
                                                type:"line",
                                                // data:[75.6,82.2,8.7,108.8,36],
                                                data:arr[3]
                                            }
                                        ]
                                    });
                                    console.log("777")
                                }else{
                                    alert("后台数据获取失败!");
                                }
                            },
                            error : function(errorMsg) {
                                //请求失败时执行该函数
                                console.log(errorMsg);
                                alert("图表请求数据失败!");
                                // t[e].hideLoading();
                            }
                        });


                        t[e].setOption(i[e]),
                         window.onresize=t[e].resize
                    };


                                    if(n[0]){l(0);
                                    var r=[],
                                        o=[
                                            {
                                                tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},
                                                legend:{data:["直接访问","邮件营销","联盟广告","视频广告","搜索引擎","百度","谷歌","必应","其他"]},
                                                calculable:!0,
                                                xAxis:[{type:"category",data:["周一","周二","周三","周四","周五","周六","周日"]}],
                                                yAxis:[{type:"value"}],
                                                series:[
                                                    {name:"直接访问",type:"bar",data:[320,332,301,334,390,330,320]},
                                                    {name:"邮件营销",type:"bar",stack:"广告",data:[120,132,101,134,90,230,210]},
                                                    {name:"联盟广告",type:"bar",stack:"广告",data:[220,182,191,234,290,330,310]},
                                                    {name:"视频广告",type:"bar",stack:"广告",data:[150,232,201,154,190,330,410]},
                                                    {name:"搜索引擎",type:"bar",
                                                        data:[862,1018,964,1026,1679,1600,1570],
                                                        markLine:{itemStyle:{normal:{lineStyle:{type:"dashed"}}},data:[[{type:"min"},{type:"max"}]]}},
                                                    {name:"百度",type:"bar",barWidth:5,stack:"搜索引擎",data:[620,732,701,734,1090,1130,1120]},
                                                    {name:"谷歌",type:"bar",stack:"搜索引擎",data:[120,132,101,134,290,230,220]},
                                                    {name:"必应",type:"bar",stack:"搜索引擎",data:[60,72,71,74,190,130,110]},
                                                    {name:"其他",type:"bar",stack:"搜索引擎",data:[62,82,91,84,109,110,120]}
                                               ]
                                            }
                                        ],
                                        m=e("#LAY-index-heapcol").children("div"),
                                        s=function(e){r[e]=a.init(m[e],layui.echartsTheme),r[e].setOption(o[e]),window.onresize=r[e].resize};
                                    if(m[0]){s(0);
                                    var y=[],
                                        d=[
                                            {
                                                title:{text:"双数值柱形图",subtext:"纯属虚构"},
                                                tooltip:{
                                                    trigger:"axis",
                                                    axisPointer:{show:!0,type:"cross",lineStyle:{type:"dashed",width:1}},
                                                    formatter:function(e){return e.seriesName+" : [ "+e.value[0]+", "+e.value[1]+" ]"}
                                                },
                                                legend:{data:["数据1","数据2"]},
                                                calculable:!0,
                                                xAxis:[{type:"value"}],
                                                yAxis:[{type:"value",axisLine:{lineStyle:{color:"#dc143c"}}}],
                                                series:[
                                                    {
                                                        name:"数据1",
                                                        type:"bar",
                                                        data:[[1.5,10],[5,7],[8,8],[12,6],[11,12],[16,9],[14,6],[17,4],[19,9]],
                                                        markPoint:{
                                                            data:[
                                                                {type:"max",name:"最大值",symbol:"emptyCircle",itemStyle:{normal:{color:"#dc143c",label:{position:"top"}}}},
                                                                {type:"min",name:"最小值",symbol:"emptyCircle",itemStyle:{normal:{color:"#dc143c",label:{position:"bottom"}}}},
                                                                {type:"max",name:"最大值",valueIndex:0,symbol:"emptyCircle",itemStyle:{normal:{color:"#1e90ff",label:{position:"right"}}}},
                                                                {type:"min",name:"最小值",valueIndex:0,symbol:"emptyCircle",itemStyle:{normal:{color:"#1e90ff",label:{position:"left"}}}}
                                                            ]
                                                        },
                                                        markLine:{
                                                            data:[
                                                                {type:"max",name:"最大值",itemStyle:{normal:{color:"#dc143c"}}},
                                                                {type:"min",name:"最小值",itemStyle:{normal:{color:"#dc143c"}}},
                                                                {type:"average",name:"平均值",itemStyle:{normal:{color:"#dc143c"}}},
                                                                {type:"max",name:"最大值",valueIndex:0,itemStyle:{normal:{color:"#1e90ff"}}},
                                                                {type:"min",name:"最小值",valueIndex:0,itemStyle:{normal:{color:"#1e90ff"}}},
                                                                {type:"average",name:"平均值",valueIndex:0,itemStyle:{normal:{color:"#1e90ff"}}}
                                                            ]
                                                        }
                                                    },
                                                    {
                                                        name:"数据2",
                                                        type:"bar",
                                                        barHeight:10,
                                                        data:[[1,2],[2,3],[4,4],[7,5],[11,11],[18,15]]
                                                    }
                                                    ]
                                            }
                                            ],
                                        c=e("#LAY-index-diffcol").children("div"),
                                        p=function(e){y[e]=a.init(c[e],layui.echartsTheme),y[e].setOption(d[e]),window.onresize=y[e].resize};
                                    if(c[0]){
                                        p(0);
                                        var u=[],
                                            x=[
                                                {
                                                    title:{x:"center",text:"ECharts例子个数统计",subtext:"Rainbow bar example",link:"http://echarts.baidu.com/doc/example.html"},
                                                    tooltip:{trigger:"item"},
                                                    calculable:!0,
                                                    grid:{borderWidth:0,y:80,y2:60},
                                                    xAxis:[{type:"category",show:!1,data:["Line","Bar","Scatter","K","Pie","Radar","Chord","Force","Map","Gauge","Funnel"]}],
                                                    yAxis:[{type:"value",show:!1}],
                                                    series:[
                                                        {name:"ECharts例子个数统计",
                                                            type:"bar",
                                                            itemStyle:{normal:{color:function(e){
                                                                var a=["#C1232B","#B5C334","#FCCE10","#E87C25","#27727B","#FE8463","#9BCA63","#FAD860","#F3A43B","#60C0DD","#D7504B","#C6E579","#F4E001","#F0805A","#26C0C0"];
                                                                return a[e.dataIndex]},label:{show:!0,position:"top",formatter:"{b}\n{c}"}}},
                                                            data:[12,21,10,4,12,5,6,5,25,23,7],
                                                            markPoint:{
                                                                tooltip:{
                                                                    trigger:"item",
                                                                    backgroundColor:"rgba(0,0,0,0)",
                                                                    formatter:function(e){
                                                                        return'<img src="'+e.data.symbol.replace("image://","")+'"/>'
                                                                    }
                                                                },
                                                                data:[
                                                                    {xAxis:0,y:350,name:"Line",symbolSize:20},
                                                                    {xAxis:1,y:350,name:"Bar",symbolSize:20},
                                                                    {xAxis:2,y:350,name:"Scatter",symbolSize:20},
                                                                    {xAxis:3,y:350,name:"K",symbolSize:20},
                                                                    {xAxis:4,y:350,name:"Pie",symbolSize:20},
                                                                    {xAxis:5,y:350,name:"Radar",symbolSize:20},
                                                                    {xAxis:6,y:350,name:"Chord",symbolSize:20},
                                                                    {xAxis:7,y:350,name:"Force",symbolSize:20},
                                                                    {xAxis:8,y:350,name:"Map",symbolSize:20},
                                                                    {xAxis:9,y:350,name:"Gauge",symbolSize:20},
                                                                    {xAxis:10,y:350,name:"Funnel",symbolSize:20}
                                                                    ]
                                                            }
                                                        }
                                                        ]
                                                }
                                              ],
                                            v=e("#LAY-index-colorline").children("div"),
                                            b=function(e){u[e]=a.init(v[e],layui.echartsTheme),u[e].setOption(x[e]),window.onresize=u[e].resize};
                                        if(v[0]){
                                        b(0);
                                        var h=[],
                                            f=[
                                                {
                                                    title:{text:"世界人口总量",subtext:"数据来自网络"},
                                                    tooltip:{trigger:"axis"},
                                                    legend:{data:["2011年","2012年"]},
                                                    calculable:!0,
                                                    xAxis:[
                                                        {type:"value",boundaryGap:[0,.01]}
                                                        ],
                                                    yAxis:[{type:"category",data:["巴西","印尼","美国","印度","中国","世界人口(万)"]}],
                                                    series:[
                                                        {name:"2011年",type:"bar",data:[18203,23489,29034,104970,131744,630230]},
                                                        {name:"2012年",type:"bar",data:[19325,23438,31e3,121594,134141,681807]}
                                                        ]
                                                }
                                                ],
                                            g=e("#LAY-index-normbar").children("div"),
                                            S=function(e){h[e]=a.init(g[e],layui.echartsTheme),h[e].setOption(f[e]),window.onresize=h[e].resize};
                                        if(g[0]){
                                        S(0);
                                        var A=[],
                                            w=[
                                                {   tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},
                                                    legend:{data:["直接访问","邮件营销","联盟广告","视频广告","搜索引擎"]},
                                                    calculable:!0,
                                                    xAxis:[{type:"value"}],
                                                    yAxis:[{type:"category",data:["周一","周二","周三","周四","周五","周六","周日"]}],
                                                    series:[
                                                        {name:"直接访问",type:"bar",stack:"总量",itemStyle:{normal:{label:{show:!0,position:"insideRight"}}},data:[320,302,301,334,390,330,320]},
                                                        {name:"邮件营销",type:"bar",stack:"总量",itemStyle:{normal:{label:{show:!0,position:"insideRight"}}},data:[120,132,101,134,90,230,210]},
                                                        {name:"联盟广告",type:"bar",stack:"总量",itemStyle:{normal:{label:{show:!0,position:"insideRight"}}},data:[220,182,191,234,290,330,310]},
                                                        {name:"视频广告",type:"bar",stack:"总量",itemStyle:{normal:{label:{show:!0,position:"insideRight"}}},data:[150,212,201,154,190,330,410]},
                                                        {name:"搜索引擎",type:"bar",stack:"总量",itemStyle:{normal:{label:{show:!0,position:"insideRight"}}},data:[820,832,901,934,1290,1330,1320]}
                                                        ]
                                                }
                                                ],
                                            k=e("#LAY-index-heapbar").children("div"),
                                            z=function(e){A[e]=a.init(k[e],layui.echartsTheme),A[e].setOption(w[e]),window.onresize=A[e].resize};
                                        if(k[0]){
                                            z(0);
                                            var L=[],
                                                C={normal:{label:{position:"right"}}},
                                                P=[
                                                    {   title:{text:"交错正负轴标签",subtext:"From ExcelHome",sublink:"http://e.weibo.com/1341556070/AjwF2AgQm"},
                                                        tooltip:{trigger:"axis",axisPointer:{type:"shadow"}},
                                                        grid:{y:80,y2:30},
                                                        xAxis:[{type:"value",position:"top",splitLine:{lineStyle:{type:"dashed"}}}],
                                                        yAxis:[
                                                            {type:"category",axisLine:{show:!1},axisLabel:{show:!1},axisTick:{show:!1},splitLine:{show:!1},data:["ten","nine","eight","seven","six","five","four","three","two","one"]
                                                        }],
                                                        series:[
                                                            {
                                                                name:"生活费",
                                                                type:"bar",
                                                                stack:"总量",
                                                                itemStyle:{
                                                                    normal:{color:"orange",borderRadius:5,label:{show:!0,position:"left",formatter:"{b}"}}},
                                                                data:[
                                                                    {value:-.07,itemStyle:C},
                                                                    {value:-.09,itemStyle:C},
                                                                    .2,
                                                                    .44,
                                                                    {value:-.23,itemStyle:C},
                                                                    .08,
                                                                    {value:-.17,itemStyle:C},
                                                                    .47,
                                                                    {value:-.36,itemStyle:C},
                                                                    .18
                                                                ]
                                                            }]}],
                                                T=e("#LAY-index-windline").children("div"),
                                                O=function(e){L[e]=a.init(T[e],layui.echartsTheme),L[e].setOption(P[e]),window.onresize=L[e].resize};
                                            T[0]&&O(0)
                                        }
                                    }
                                    }
                                    }}}}),

           //地图
        layui.use(["carousel","echarts"],function(){
                var e=layui.$,
                    a=(layui.carousel,layui.echarts),
                    t=[],
                    i=[
                        {
                            title:{text:"2011全国GDP（亿元）",subtext:"数据来自国家统计局"},
                            tooltip:{trigger:"item"},
                            dataRange:{orient:"horizontal",min:0,max:55e3,text:["高","低"],splitNumber:0},
                            series:[
                                {
                                    name:"2011全国GDP分布",
                                    type:"map",
                                    mapType:"china",
                                    mapLocation:{x:"center"},
                                    selectedMode:"multiple",
                                    itemStyle:{normal:{label:{show:!0}},emphasis:{label:{show:!0}}},
                                    data:[
                                        {name:"西藏",value:605.83},
                                        {name:"青海",value:1670.44},
                                        {name:"宁夏",value:2102.21},
                                        {name:"海南",value:2522.66},
                                        {name:"甘肃",value:5020.37},
                                        {name:"贵州",value:5701.84},
                                        {name:"新疆",value:6610.05},
                                        {name:"云南",value:8893.12},
                                        {name:"重庆",value:10011.37},
                                        {name:"吉林",value:10568.83},
                                        {name:"山西",value:11237.55},
                                        {name:"天津",value:11307.28},
                                        {name:"江西",value:11702.82},
                                        {name:"广西",value:11720.87},
                                        {name:"陕西",value:12512.3},
                                        {name:"黑龙江",value:12582},
                                        {name:"内蒙古",value:14359.88},
                                        {name:"安徽",value:15300.65},
                                        {name:"北京",value:16251.93,selected:!0},
                                        {name:"福建",value:17560.18},
                                        {name:"上海",value:19195.69,selected:!0},
                                        {name:"湖北",value:19632.26},{
                                        name:"湖南",value:19669.56},
                                        {name:"四川",value:21026.68},
                                        {name:"辽宁",value:22226.7},
                                        {name:"河北",value:24515.76},
                                        {name:"河南",value:26931.03},
                                        {name:"浙江",value:32318.85},
                                        {name:"山东",value:45361.85},
                                        {name:"江苏",value:49110.27},
                                        {name:"广东",value:53210.28,selected:!0}
                                        ]
                                }]}
                    ],
                    n=e("#LAY-index-plat").children("div"),
                    l=function(e){t[e]=a.init(n[e],layui.echartsTheme),t[e].setOption(i[e]),window.onresize=t[e].resize};
                n[0]&&l(0)}),e("senior",{})});