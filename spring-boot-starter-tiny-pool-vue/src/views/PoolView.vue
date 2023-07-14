<template>
    <div id="main">
        <h1>This is an about page{{ desc }}</h1>
    </div>
</template>

<script>

import * as echarts from 'echarts';

export default {
    name: 'PoolView',
    data: function () {
        return {
            desc: '111'
        }
    },
    mounted: function () {
        var myChart = echarts.init(document.getElementById('main'));
        myChart.setOption({
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            xAxis: {
                data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
            },
            yAxis: {},
            series: [
                {
                    name: '销量',
                    type: 'bar',
                    data: [5, 20, 36, 10, 10, 20]
                }
            ]
        });
    }

}
</script>

<style scoped>

#main {
    width: 400px;
    height: 400px;
}

</style>