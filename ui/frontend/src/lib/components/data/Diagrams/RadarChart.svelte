<script lang="ts">
    import { Radar } from 'svelte-chartjs';
    import { data } from './radar-data.js';

    import {
        Chart as ChartJS,
        Title,
        Tooltip,
        Legend,
        PointElement,
        RadialLinearScale,
        LineElement,
    } from 'chart.js';

    ChartJS.register(
        Title,
        Tooltip,
        Legend,
        PointElement,
        RadialLinearScale,
        LineElement
    );
</script>

<Radar {data} options={{ responsive: true }} />
