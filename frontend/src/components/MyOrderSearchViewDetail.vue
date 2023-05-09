<template>

    <v-card outlined>
        <v-card-title>
            MyOrderSearch # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="ProductName" v-model="item.productName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ProductQty" v-model="item.productQty" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="OrderId" v-model="item.orderId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OrderStatus" v-model="item.orderStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="DeliveryId" v-model="item.deliveryId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'MyOrderSearchViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/myOrderSearches/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

