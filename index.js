const PORT = process.env.PORT || 8006
const express = require('express')
const axios = require('axios')
const cheerio = require('cheerio')
const app = express()

const beginning = "Welcome to the eticaretapi"

const product = [
    {
        id: 1,
        name: 'Samsung Galaxy Z Flip4',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-f721blvatur/gallery/tr-galaxy-z-flip4-f721-sm-f721blvatur-thumb-534178360?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-f721bzaatur/gallery/tr-galaxy-z-flip4-f721-sm-f721bzaatur-thumb-534178367?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-f721blbatur/gallery/tr-galaxy-z-flip4-f721-sm-f721blbatur-thumb-534178352?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-f721bzdatur/gallery/tr-galaxy-z-flip4-f721-sm-f721bzdatur-thumb-534178376?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'smartphone',
        memory: 128,
        color: [
            'Purple','Grey','Blue','Pink'
        ],
        price: 29999
    },
    {
        id: 2,
        name: 'Samsung Galaxy Z Fold4',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2208/gallery/tr-galaxy-z-fold4-f936-sm-f936bzadtur-thumb-533117928?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2208/gallery/tr-galaxy-z-fold4-f936-sm-f936bzkdtur-thumb-533117966?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2208/gallery/tr-galaxy-z-fold4-f936-sm-f936bzedtur-thumb-533117947?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'smartphone',
        memory: 256,
        color: [
            'Grey','Black','Beige'
        ],
        price: 44999
    },
    {
        id: 3,
        name: 'Samsung Galaxy S22 Ultra',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-ultra-s908-sm-s908edrdtur-thumb-530980042?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-ultra-s908-sm-s908ezkdtur-thumb-530980264?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-ultra-s908-sm-s908ezgdtur-thumb-530980153?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-ultra-s908-sm-s908ezwdtur-thumb-530980375?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'smartphone',
        memory: 128,
        color: [
            'Burgundy','Black','Green','White'
        ],
        price: 35999
    },
    {
        id: 4,
        name: 'Samsung Galaxy S22+',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-plus-s906-413055-sm-s906ezwdtur-thumb-530971176?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-plus-s906-413055-sm-s906ezkdtur-thumb-530971138?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-plus-s906-413055-sm-s906ezgdtur-thumb-530971100?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-plus-s906-413055-sm-s906eiddtur-thumb-530971062?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'smartphone',
        memory: 128,
        color: [
            'White','Black','Green','Pink'
        ],
        price: 29499
    },
    {
        id: 5,
        name: 'Samsung Galaxy S22',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-s901-413020-sm-s901ezwdtur-thumb-530969409?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-s901-413020-sm-s901ezkdtur-thumb-530969390?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-s901-413020-sm-s901ezgdtur-thumb-530969371?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-s901elvdtur/gallery/tr-galaxy-s22-s901-413020-413020-sm-s901elvdtur-thumb-533544719?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2202/gallery/tr-galaxy-s22-s901-413020-sm-s901eiddtur-thumb-530969352?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'smartphone',        
        memory: 128,
        color: [
            'White','Black','Green','Purple','Pink'
        ],
        price: 22999
    },
    {
        id: 6,
        name: 'Samsung Galaxy Tab S8 Ultra',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x900nzaetur/gallery/tr-galaxy-tab-s8-ultra-wifi-x900-sm-x900nzaetur-thumb-534178513?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'tablet',          
        memory: 128,
        color: [
            'Black'
        ],
        price: 17799
    },
    {
        id: 7,
        name: 'Samsung Galaxy Tab S8+',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x800nzaatur/gallery/tr-galaxy-tab-s8-plus-wifi-x800-sm-x800nzaatur-thumb-534178457?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x800nzsatur/gallery/tr-galaxy-tab-s8-plus-wifi-x800-sm-x800nzsatur-thumb-534178467?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x800nidatur/gallery/tr-galaxy-tab-s8-plus-wifi-x800-sm-x800nidatur-thumb-534178444?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'tablet',          
        memory: 128,
        color: [
            'Black','White','Pink'
        ],
        price: 15259
    },
    {
        id: 8,
        name: 'Samsung Galaxy Tab S8',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x700nzaatur/gallery/tr-galaxy-tab-s8-wifi-x700-sm-x700nzaatur-thumb-534178408?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x700nzsatur/gallery/tr-galaxy-tab-s8-wifi-x700-sm-x700nzsatur-thumb-534178421?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x700nidatur/gallery/tr-galaxy-tab-s8-wifi-x700-sm-x700nidatur-thumb-534178397?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'tablet',   
        memory: 128,
        color: [
            'Black','White','Pink'
        ],
        price: 12719
    },
    {
        id: 9,
        name: 'Samsung Galaxy Tab A8 LTE',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x207nzaatur/gallery/tr-galaxy-a8-sm-x207-sm-x207nzaatur-thumb-530734780?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x207nzsatur/gallery/tr-galaxy-a8-sm-x207-sm-x207nzsatur-thumb-530734803?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x207nidatur/gallery/tr-galaxy-a8-sm-x207-sm-x207nidatur-thumb-530734757?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'tablet',   
        memory: 32,
        color: [
            'Black','White','Pink'
        ],
        price: 4499
    },
    {
        id: 10,
        name: 'Samsung Galaxy Tab A8 WIFI',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x200nzaatur/gallery/tr-galaxy-a8-sm-x200-sm-x200nzaatur-thumb-530734591?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x200nzsatur/gallery/tr-galaxy-a8-sm-x200-sm-x200nzsatur-thumb-530734614?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-x200nidatur/gallery/tr-galaxy-a8-sm-x200-sm-x200nidatur-thumb-530734568?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'tablet',  
        memory: 32,
        color: [
            'Black','White','Pink'
        ],
        price: 3499
    },
    {
        id: 11,
        name: 'Samsung Galaxy Watch5 Pro',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2208/gallery/tr-galaxy-watch5-pro-sm-r920nzkatur-thumb-533193749?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2208/gallery/tr-galaxy-watch5-pro-sm-r920nztatur-thumb-533193802?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'watch',  
        memory: 0,
        color: [
            'Black','Grey'
        ],
        price: 7999
    },
    {
        id: 12,
        name: 'Samsung Galaxy Watch5',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2208/gallery/tr-galaxy-watch5-44mm-sm-r910nzaatur-thumb-533188255?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2208/gallery/tr-galaxy-watch5-44mm-sm-r910nzbatur-thumb-533188269?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2208/gallery/tr-galaxy-watch5-44mm-sm-r910nzsatur-thumb-533188284?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'watch',  
        memory: 128,
        color: [
            'White','Black','Pink'
        ],
        price: 4499
    },
    {
        id: 13,
        name: 'Samsung Galaxy Watch4 Classic',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2108/gallery/tr-galaxy-watch4-classic-sm-r880nzkatur-thumb-481126973?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2108/gallery/tr-galaxy-watch4-classic-sm-r880nzsatur-thumb-481126986?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'watch',  
        memory: 0,
        color: [
            'Black','White'
        ],
        price: 4299
    },
    {
        id: 14,
        name: 'Samsung Galaxy Watch4',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2108/gallery/tr-galaxy-watch4-398833-sm-r870nzkatur-thumb-481098523?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2108/gallery/tr-galaxy-watch4-398833-sm-r870nzgatur-thumb-481098434?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2108/gallery/tr-galaxy-watch4-398833-sm-r870nzsatur-thumb-481098564?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'watch',  
        memory: 0,
        color: [
            'Black','Green','White'
        ],
        price: 3699
    },
    {
        id: 15,
        name: 'Samsung Galaxy Watch3',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-r840ntkatur/gallery/tr-galaxy-watch3-r840-374742-sm-r840ntkatur-thumb-384116146?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'watch',  
        memory: 0,
        color: [
            'Black'
        ],
        price: 2699
    },
    {
        id: 16,
        name: 'Samsung Galaxy Buds2 Pro',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2208/gallery/tr-galaxy-buds2-pro-r510-sm-r510nlvatur-thumb-533195810?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2208/gallery/tr-galaxy-buds2-pro-r510-sm-r510nzaatur-thumb-533195869?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2208/gallery/tr-galaxy-buds2-pro-r510-sm-r510nzwatur-thumb-533195925?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'earphone',  
        memory: 0,
        color: [
            'Purple','Black','White'
        ],
        price: 3499
    },
    {
        id: 17,
        name: 'Samsung Galaxy Buds2',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2108/gallery/tr-galaxy-buds2-r177-sm-r177nzkatur-thumb-481688701?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/sm-r177nztatur/gallery/tr-galaxy-buds2-r177-399637-sm-r177nztatur-thumb-532663621?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2108/gallery/tr-galaxy-buds2-r177-sm-r177nzgatur-thumb-481688682?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2108/gallery/tr-galaxy-buds2-r177-sm-r177nlvatur-thumb-481688663?$160_160_PNG$',
            'https://images.samsung.com/is/image/samsung/p6pim/tr/2108/gallery/tr-galaxy-buds2-r177-sm-r177nzwatur-thumb-481688720?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'earphone',  
        memory: 0,
        color: [
            'Grey','Black','Green','Purple','White'
        ],
        price: 1499
    },
    {
        id: 18,
        name: 'Samsung Level U2',
        image: [
            'https://images.samsung.com/is/image/samsung/p6pim/tr/eo-b3300blegww/gallery/tr-others-eo-b3300blegww-front-blue-thumb-375588350?$160_160_PNG$'
        ],
        description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
        category: 'earphone',  
        memory: 0,
        color: [
            'Black'
        ],
        price: 999
    },
]


app.get('/', (req, res) => {
    res.json(beginning)
})

app.get('/product', (req, res) => {
    res.json(product)
})


app.listen(PORT, () => console.log(`server running on PORT ${PORT}`))



