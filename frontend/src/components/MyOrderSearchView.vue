<template>

    <v-data-table
        :headers="headers"
        :items="myOrderSearch"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MyOrderSearchView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "productName", value: "productName" },
                { text: "productQty", value: "productQty" },
                { text: "orderId", value: "orderId" },
                { text: "orderStatus", value: "orderStatus" },
                { text: "deliveryId", value: "deliveryId" },
                { text: "status", value: "status" },
            ],
            myOrderSearch : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/myOrderSearches'))

            temp.data._embedded.myOrderSearches.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.myOrderSearch = temp.data._embedded.myOrderSearches;
        },
        methods: {
        }
    }
</script>

