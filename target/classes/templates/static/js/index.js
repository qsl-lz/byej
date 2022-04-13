var basePath = "/" + window.location.pathname.split("/")[1];
var indexApp = new Vue({
    el: "#indexApp",
    data() {
        return {
            activeIndex:'首页',
            userObj:{},
            cusTableLstInit:[],
            userList:[]
        }
    },
    created() {
        this.userObj=JSON.parse(localStorage.getItem("webInfo")) || [];
    },
    mounted() {
        this.getYcList();
        this.getYcUser();
        this.getMapData();
    },
    methods: {
        toJdDetails(id){
            window.location.href=basePath+"/jd_details?id="+id;
        },
        toCenter(){
            window.location.href=basePath+"/center";
        },
        toIndex(){
            location.reload();
        },
        curSelect(val,name){
            this.activeIndex=val;
            if(val==1){
                window.location.href=basePath+"/index";
            }else if(val==2){
                window.location.href=basePath+"/news";
            }else if(val==3){
                window.location.href=basePath+"/comment";
            }
        },
        loginOut(){
            window.location.href=basePath+"/login";
            localStorage.removeItem("webInfo")
        },
        getYcList(){
            let that = this;
            $.ajax({
                type: "GET",
                url: `${basePath}/region_manage/queryRegionManageKey`,
                data: {},
                success: function (data) {
                    that.cusTableLstInit = data.data;
                }
            })
        },
        getYcUser(){
            let that = this;
            $.ajax({
                type: "GET",
                url: `${basePath}/app_user/queryAppUserKey`,
                data: {is_yc:2},
                success: function (data) {
                    that.userList = data.data;
                }
            })
        },
        getMapData(){
            let that = this;
            $.ajax({
                type: "GET",
                url: `${basePath}/province_num_manage/queryProvinceNumManageKey`,
                data: {},
                success: function (data) {
                    that.setMapData(data.data);
                }
            })
        },

        setMapData(mydata){
            var optionMap = {
                backgroundColor: '#FFFFFF',
                title: {
                    text: '游客来源统计图',
                    subtext: '',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item'
                },


                //左侧小导航图标
                visualMap: {
                    show : true,
                    x: 'left',
                    y: 'center',
                    splitList: [
                        {start: 500, end:600},{start: 400, end: 500},
                        {start: 300, end: 400},{start: 200, end: 300},
                        {start: 100, end: 200},{start: 0, end: 100},
                    ],
                    color: ['#5475f5', '#9feaa5', '#85daef','#74e2ca', '#e6ac53', '#9fb5ea']
                },

                //配置属性
                series: [{
                    name: '游客数量',
                    type: 'map',
                    mapType: 'china',
                    roam: true,
                    label: {
                        normal: {
                            show: true  //省份名称
                        },
                        emphasis: {
                            show: false
                        }
                    },
                    data:mydata  //数据
                }]
            };
            console.log(mydata);
            //初始化echarts实例
            var myChart = echarts.init(document.getElementById('dataMap'));
            console.log(myChart);

            //使用制定的配置项和数据显示图表
            myChart.setOption(optionMap);
        }

    }
})