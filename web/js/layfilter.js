layui.define(['jquery', 'layer'], function (exports){
    var $ = layui.jquery;
    var chekedArr = {};
    var layfilter = {
        render:function(options){
            var url = options.url;
            var flag = true;
            //传入了地址，则直接将此地址覆盖
            if(url){
                $.getJSON(url,options.where,function(res){
                    if(res.code == 0){
                       var  data = res.data;
                        flase = true;
                        layfilter.init(options,data);
                    }else{
                        layer.msg(res.msg||'查询过滤组件数据异常',{icon:2});
                        flag = false
                    }
                })
            }
            if(!flag){
                return;
            }
        },
        init:function(options,dataSource){
            var elem = options.elem;
            var $dom = $(elem);
            var itemWidth = options.itemWidth
            var arr = {};
            var $table = $('<table class="filterTable"></table>');
            for(var i=0;i<dataSource.length;i++){
                var $tr =$('<tr></tr>');
                var $td1 = $('<td class="item-title">'+dataSource[i].title+':</td>');
                var $td2 = $('<td class="items"></td>');
                var type = dataSource[i].type;
                if(!type){
                    console.warn('第'+(i+1)+'个元素的类型[type]为空设为默认值[radio]');
                    type = 'radio';
                }
                var $ul = $('<ul class="layfilter-ul" type="'+type+'" name="'+dataSource[i].name+'"></ul>');
                var width = itemWidth && itemWidth.length>0 ? (itemWidth.length>i ? itemWidth[i]:itemWidth[itemWidth.length-1]):80;
                arr[dataSource[i].name]=[];
                for(var j=0;j<dataSource[i].data.length;j++){
                    var item =  dataSource[i].data;
                    var className = 'layfilter-item';
                    if(item[j].checked && item[j].checked=='true'){
                        className = "layfilter-item layfilter-item-checked";
                        arr[dataSource[i].name].push({name:item[j].name,value:item[j].value});
                    }
                    //判断是否禁用
                    if(item[j].disabled && item[j].disabled=='true'){
                        $ul.append('<li value="'+item[j].value+'" style="width:'+width+'px;height: 28px;line-height: 28px;" class="'+className+'"><a disabled="disabled" class="layui-disabled">'+item[j].name+'</a></li>');
                    }else{
                        $ul.append('<li value="'+item[j].value+'" style="width:'+width+'px;height: 28px;line-height: 28px;" class="'+className+'"><a>'+item[j].name+'</a></li>');
                    }
                    
                }
                $td2.append($ul);
                $tr.append($td1).append($td2);
                $table.append($tr);
            }
            $dom.append($table);
            chekedArr=arr;
            //注册点击事件
            $('.filterTable tr td li a').bind('click',function(){
                if($(this).attr('disabled')){
                    return;
                }
                var itemType = $(this).parent().parent().attr('type');
                var name =  $(this).parent().parent().attr('name');
                //取消选择
                if($(this).parent().hasClass('layfilter-item-checked')){
                    $(this).parent().removeClass('layfilter-item-checked');
                    var obj = chekedArr[name]||[];
                    for(var i=0;i<obj.length;i++){
                        if(obj[i].value==$(this).parent().attr('value')){
                            obj.splice(i, 1);
                            break;
                        }
                    }
                    chekedArr[name] = obj;
                }else{
                    if(itemType && ('checbox' == itemType || 'radio' == itemType)){
                        //判断类型
                        if('radio' == itemType){
                            var objs = $(this).parent().siblings();
                            chekedArr[name]=[];
                            for(var i=0;i<objs.length;i++){
                                objs.eq(i).removeClass('layfilter-item-checked');
                            }
                        }
                        var obj = chekedArr[name]||[];
                        obj.push({name:$(this).text(),value:$(this).parent().attr('value')});
                        chekedArr[name]=obj;
                        $(this).parent().addClass('layfilter-item-checked');
                    }else{
                        console.error('复选或单选类型为空？');
                    }
                }
            });
        },
        getValue:function(callback){
            var obj = getCheckData();
            callback.call(this,obj);
        },
        on:function(filter,callback){
            var f = filter.substring(0,filter.indexOf('('));
            var e =  filter.substring(filter.indexOf('(')+1,filter.length-1);
            if(typeof callback === "function"){
                $("[lay-filter='"+e+"']").on(f,function(){
                    var obj = getCheckData();
                    
                    callback.call(this,obj);
                });
            }else{
                console.error('传入的参数不是一个函数');
            }
        }
    }

    layui.link(layui.cache.base + 'layfilter/layfilter.css');

    function getCheckData(){
        var valueJson = {};
        var nameJson = {};
        for(var name in chekedArr){
            var json = chekedArr[name];
            var values = '';
            var names = '';
            for(var i=0;i<json.length;i++){
                if(i!=json.length-1){
                    values+=json[i].value+",";
                    names +=json[i].name+",";
                }else{
                    values+=json[i].value;
                    names +=json[i].name;
                }
                
            }
            valueJson[name]=values;
            nameJson[name]=names;
        }
        return {values:valueJson,names:nameJson};
    }

    exports('layfilter', layfilter);
})