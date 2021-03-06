// jshint ignore: start
+function($){

    $.paymentData = [
        {
            "name":"二维码被扫",
            "value":"100000",
            "type":"1",
            "sub":[
                {
                    "name":"ETS直连渠道",
                    "value":"100100",
                    "sub":[
                        {
                            "name":"支付宝被扫",
                            "value":"100101"
                        },
                        {
                            "name":"微信被扫",
                            "value":"100102"
                        },
                        {
                            "name":"银联云闪付被扫",
                            "value":"100103"
                        }
                    ]
                },
                {
                    "name":"威富通渠道",
                    "value":"100200",
                    "sub":[
                        {
                            "name":"支付宝被扫",
                            "value":"100201"
                        },
                        {
                            "name":"微信被扫",
                            "value":"100202"
                        },
                        {
                            "name":"银联云闪付被扫",
                            "value":"100203"
                        }
                    ]
                }
            ]
        },
        {
            "name":"二维码主扫",
            "value":"110000",
            "type":"1",
            "sub":[
                {
                    "name":"威富通渠道",
                    "value":"110100",
                    "sub":[
                        {
                            "name":"支付宝主扫",
                            "value":"110101"
                        },
                        {
                            "name":"微信主扫",
                            "value":"110102"
                        },
                        {
                            "name":"银联云闪付主扫",
                            "value":"110103"
                        }
                    ]
                }
            ]
        },
        {
            "name":"二维码代扣",
            "value":"130000",
            "type":"0",
            "sub":[
                {
                    "name":"翼支付代扣",
                    "value":"130100"
                }
            ]
        },
        {
            "name":"人脸代扣",
            "value":"140000",
            "type":"0",
            "sub":[
                {
                    "name":"支付宝人脸代扣",
                    "value":"140100"
                },
                {
                    "name":"微信宝人脸代扣",
                    "value":"140200"
                }
            ]
        }
    ];
}($);

