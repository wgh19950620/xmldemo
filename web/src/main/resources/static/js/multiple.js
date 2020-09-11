/**
 * @authors Mzong(mzong121491@gmail.com)
 * @date    2019-01-18 11:15
 * @requires  layui
 * @version $1.1.0$
 */
layui.define("layer", function(exports){
    //提示：模块也可以依赖其它模块，如：layui.define('layer', callback);
    var $ = layui.jquery,
        form = layui.form;
    // 返回的对象
    var returnObj = {
        /**
         * 省市县三级联动
         *
         * @param { string } [form] [form是layui.form对象]
         * @param {string} [province] [省容器的name名字 ]
         *    eg:<select name="province">
         * @param {string} [city] [省容器的name名字]
         * @param {string} [district] [县容器的name名字]
         * @return {undefined} [无返回值]
         */
        showMultiple: function(paymentType, paymentChannel, paymentPattern) {
            //AreaData是地址传过来的json对象
            var paymentTypeData = $.paymentData;

            var htmlPaymentType = '',
                htmlPaymentChannel = '',
                htmlPaymentPattern = '',
                paymentChannelData = '',
                paymentPatternData = '',
                $paymentType = $('select[name='+paymentType+']'),
                $paymentChannel = $('select[name='+paymentChannel+']'),
                $paymentPattern = $('select[name='+paymentPattern+']'),
                ptVal = $paymentType.attr('data-area') || '', // 省默认值
                pcVal = $paymentChannel.attr('data-area') || '', // 市默认值
                ppVal = $paymentPattern.attr('data-area') || ''; // 县默认值
            $paymentType.find('option').not(':first').remove();
            $paymentChannel.find('option').not(':first').remove();
            $paymentPattern.find('option').not(':first').remove();
            form.render('select');

            // 加载省数据
            loadPaymentType();
            function loadPaymentType() {
                paymentTypeData.forEach(function(v, i) {
                    htmlPaymentType += '<option value='+v.value+'>'+v.name+'</option>';
                });
                $paymentType.append(htmlPaymentType);

                // 默认选中省
                defaultSelect($paymentType, ptVal, function(value) {
                    paymentChannelData = findPlace(paymentTypeData, value);
                    loadPaymentChannel(paymentChannelData, true);
                });

                form.render('select');

            }

            // 加载城市数据
            function loadPaymentChannel(paymentChannelData, hasDefault) {
                $paymentChannel.find('option').not(':first').remove();
                htmlPaymentChannel = '';
                var paymentChannel = paymentChannelData || [];
                paymentChannel.forEach(function(v, i) {
                    htmlPaymentChannel += '<option value='+v.value+'>'+v.name+'</option>';
                });
                $paymentChannel.append(htmlPaymentChannel);

                // 默认加载才执行，手动选中不执行
                if (hasDefault) {
                    // 默认选中城市
                    defaultSelect($paymentChannel, pcVal, function(value) {
                        // console.log(code)
                        // 加载默认城市数据
                        paymentPatternData = findPlace(paymentChannelData, value);
                        loadPaymentPattern(paymentPatternData, true);
                    });
                }

                form.render('select');
            }

            // 加载县数据
            function loadPaymentPattern(paymentPatternData, hasDefault) {
                $paymentPattern.find('option').not(':first').remove();
                htmlPaymentPattern = '';
                var paymentPatternData = paymentPatternData || [];
                paymentPatternData.forEach(function(v, i) {
                    htmlPaymentPattern += '<option value='+v.value+'>'+v.name+'</option>';
                });
                console.log('htmlPaymentPattern:'+htmlPaymentPattern);
                $paymentPattern.append(htmlPaymentPattern);
                console.log('$paymentPattern:'+$paymentPattern);

                if (hasDefault) {
                    // 默认选中县
                    defaultSelect($paymentPattern, ppVal);
                }

                form.render('select');
            }

            // 查找地点数据
            function findPlace(data, value) {
                var resData = [];
                data.forEach(function(v, i) {
                    if (v.value === value) {
                        resData = v.sub
                    }
                });

                return resData;
            }

            /*
            * 查找默认选中项
            * @param {object} jq元素
            * @param {string} 默认值
            * @param {function} 回调函数
            */
            function defaultSelect($el, SelectVal, callback) {
                $('option', $el).each(function(i, el) {
                    var $this = $(this);
                    var optVal = $this.html();
                    var value;
                    if (optVal == SelectVal) {
                        $this.attr("selected", true);
                        value = $this.val();
                        // 加载默认城市数据
                        callback && callback(value);
                    }
                });
            }

            // 省选择
            form.on('select('+paymentType+')', function(data) {
                var value = data.value;
                // console.log(data.elem); //得到select原始DOM对象
                // console.log(value); //得到被选中的值
                if (value != '') {

                    paymentChannelData = findPlace(paymentTypeData, value);

                    loadPaymentChannel(paymentChannelData);
                    loadPaymentPattern();

                } else {
                    loadPaymentChannel();
                    loadPaymentPattern();
                }
                // console.log(data.othis); //得到美化后的DOM对象
            });
            // 市选择
            form.on('select('+paymentChannel+')', function(data){
                var value = data.value;
                if (value != '') {

                    paymentPatternData = findPlace(paymentChannelData, value);

                    loadPaymentPattern(paymentPatternData);
                    // console.log(data.elem); //得到select原始DOM对象
                } else {
                    loadPaymentPattern();
                }
                // console.log(data.othis); //得到美化后的DOM对象
            });
            form.on('select('+paymentPattern+')', function(data){
                // console.log(data.elem); //得到select原始DOM对象
                // console.log(data.value); //得到被选中的值
                // console.log(data.othis); //得到美化后的DOM对象
            });
        },
        /**
         * 获取省市县数据
         *
         * @param { object } [address] [address eg:广东省广州市天河区]
         * @return {object} [address][根据value码返回地址名称]
         */
        getCity: function(address) {
            //AreaData是地址传过来的json对象
            var paymentTypeData = $.paymentData;

            var paymentType = address.paymentType,
                paymentChannel = address.paymentChannel,
                paymentPattern = address.paymentPattern,
                paymentTypeName = '',
                paymentChannelName = '',
                paymentPatternName = '';

            function findIndex(arr, target) {
                return arr.findIndex(function(v, i) {
                    return target == v.value;
                })
            }

            if (paymentType) {
                var findProvinceIndex = findIndex(paymentTypeData, paymentType);
                paymentTypeName = paymentTypeData[findProvinceIndex].name;
            }

            if (paymentType && paymentChannel) {
                var findCityIndex = findIndex(paymentTypeData[findProvinceIndex].sub, paymentChannel);
                paymentChannelName = paymentTypeData[findProvinceIndex].sub[findCityIndex].name;
            }

            if (paymentType && paymentChannel && paymentPattern) {
                var findDistrictIndex = findIndex(paymentTypeData[findProvinceIndex].sub[findCityIndex].sub, paymentPattern);

                paymentPatternName = paymentTypeData[findProvinceIndex].sub[findCityIndex].sub[findDistrictIndex].name;
            }

            return {
                paymentTypeName: paymentTypeName,
                paymentChannelName: paymentChannelName,
                paymentPatternName: paymentPatternName
            }
        }
    }

    // exports module
    exports('multiple', returnObj);
});
