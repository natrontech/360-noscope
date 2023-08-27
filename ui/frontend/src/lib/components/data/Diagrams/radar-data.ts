function getRandomData() {
    return Math.floor(Math.random() * 11); // generate a random number between 0 and 10
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
                getRandomData(),
                getRandomData(),
                getRandomData(),
                getRandomData(),
                getRandomData(),
                getRandomData(),
                getRandomData(),
            ],
        },
        {
            label: 'Qualitative Data',
            backgroundColor: 'rgba(71, 225, 167, 0.5)',
            borderColor: 'rgb(71, 225, 167)',
            data: [
                getRandomData(),
                getRandomData(),
                getRandomData(),
                getRandomData(),
                getRandomData(),
                getRandomData(),
                getRandomData(),
            ],
        },
    ],
};
