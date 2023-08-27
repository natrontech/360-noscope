function getRandomData(min: number, max: number) {
    return (Math.random() * (max - min) + min).toFixed(1);
}

export const data = {
    labels: [
        'Sicherheit',
        'Gesundheit',
        'Umwelt',
        'Verkehr',
        'Bildung',
        'Wirtschaft',
        'Kultur',
    ],
    datasets: [
        {
            label: 'Quantitative Data',
            backgroundColor: 'rgba(194, 116, 161, 0.5)',
            borderColor: 'rgb(194, 116, 161)',
            data: [
                getRandomData(0, 10),
                getRandomData(0, 10),
                getRandomData(0, 10),
                getRandomData(0, 10),
                getRandomData(0, 10),
                getRandomData(0, 10),
                getRandomData(0, 10),
            ],
        },
        {
            label: 'Qualitative Data',
            backgroundColor: 'rgba(71, 225, 167, 0.5)',
            borderColor: 'rgb(71, 225, 167)',
            data: [
                getRandomData(0, 10),
                getRandomData(0, 10),
                getRandomData(0, 10),
                getRandomData(0, 10),
                getRandomData(0, 10),
                getRandomData(0, 10),
                getRandomData(0, 10),
            ],
        },
    ],
};
