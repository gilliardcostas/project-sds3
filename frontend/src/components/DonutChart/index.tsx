import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SomaVendas } from 'types/venda';
import { BASE_URL } from 'utils/request';

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {

    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${BASE_URL}/vendas/quantia-por-vendedor`)
            .then(response => {
                const data = response.data as SomaVendas[];
                const myLabels = data.map(x => x.nomeVendedor);
                const mySeries = data.map(x => x.soma)

                setChartData({ labels: myLabels, series: mySeries })
            });
    }, [])

    /* UMA FORMA DE FAZER O PROCESSO
    let chartData : ChartData = { labels: [], series: []}
        
    axios.get(`${BASE_URL}/vendas/quantia-por-vendedor`)
        .then(response => {
            const data = response.data as SomaVendas[];
            const myLabels = data.map(x => x.nomeVendedor);
            const mySeries = data.map(x => x.soma)

            setChartData({ labels: myLabels, series: mySeries})
            console.log(chartData);
        });
    */

    /* Estatico:
    const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }*/

    const options = {
        legend: {
            show: true
        }
    }

    return (

        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />

    );
}

export default DonutChart;
