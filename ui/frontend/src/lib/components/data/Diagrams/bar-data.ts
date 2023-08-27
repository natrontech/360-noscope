export const randomData: [] = [];

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
            data: randomData
        },
        {
            label: 'Qualitative Data',
            backgroundColor: 'rgba(71, 225, 167, 0.5)',
            borderColor: 'rgb(71, 225, 167)',
            data: randomData
        },
    ],
};
