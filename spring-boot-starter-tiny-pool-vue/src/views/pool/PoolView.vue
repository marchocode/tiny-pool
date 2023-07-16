<template>
    <div id="main">

    </div>
</template>

<script>

import * as echarts from 'echarts';
import { PoolDetail } from "@/api/requests"

export default {
    name: 'PoolView',
    data: function () {
        return {
            poolInfo: {
                corePoolSize: 0,
                maximumPoolSize: 0,
                activeCount: 0,
            },
            gaugeData: [
                {
                    value: 0,
                    name: 'Core',
                    title: {
                        offsetCenter: ['-40%', '80%']
                    },
                    detail: {
                        offsetCenter: ['-40%', '95%']
                    }
                },
                {
                    value: 0,
                    name: 'Activite',
                    title: {
                        offsetCenter: ['0%', '80%']
                    },
                    detail: {
                        offsetCenter: ['0%', '95%']
                    }
                },
                {
                    value: 0,
                    name: 'Max',
                    title: {
                        offsetCenter: ['40%', '80%']
                    },
                    detail: {
                        offsetCenter: ['40%', '95%']
                    }
                }
            ]
        }
    },
    computed: {
        poolKey() {
            return this.$route.params.name;
        }
    },
    created() {

    },

    mounted: function () {

        var chartDom = document.getElementById('main');
        var myChart = echarts.init(chartDom);
        var option;

        option = {
            series: [
                {
                    type: 'gauge',
                    min: 0,
                    max: 10,
                    anchor: {
                        show: true,
                        showAbove: true,
                        size: 18,
                        itemStyle: {
                            color: '#FAC858'
                        }
                    },
                    pointer: {
                        icon: 'path://M2.9,0.7L2.9,0.7c1.4,0,2.6,1.2,2.6,2.6v115c0,1.4-1.2,2.6-2.6,2.6l0,0c-1.4,0-2.6-1.2-2.6-2.6V3.3C0.3,1.9,1.4,0.7,2.9,0.7z',
                        width: 8,
                        length: '80%',
                        offsetCenter: [0, '8%']
                    },
                    progress: {
                        show: true,
                        overlap: true,
                        roundCap: true
                    },
                    axisLine: {
                        roundCap: true
                    },
                    data: [],
                    title: {
                        fontSize: 14
                    },
                    detail: {
                        width: 40,
                        height: 14,
                        fontSize: 14,
                        color: '#fff',
                        backgroundColor: 'inherit',
                        borderRadius: 3,
                        formatter: '{value}'
                    }
                }
            ]
        };

        myChart.setOption(option);

        PoolDetail(this.poolKey).then(res => {
            this.poolInfo = res.data
            this.gaugeData[0].value = res.data.corePoolSize
            this.gaugeData[1].value = res.data.activeCount
            this.gaugeData[2].value = res.data.maximumPoolSize

            
            myChart.setOption({series:[
                {
                    data: this.gaugeData
                }
            ]});
        })

    }

}
</script>

<style scoped>
#main {
    width: 400px;
    height: 400px;
}
</style>