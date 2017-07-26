/**
 * Created by 蛋 on 2017/7/22.
 */
/**适用于CSS2*/
function getStyle(obj,name) {
    if(obj.currentStyle){
        return obj.currentStyle[name];
    }else{
        return getComputedStyle(obj,false)[name];
    }
}
function startMove(obj,json,fn) {
    clearInterval(obj.timer);
    obj.timer = setInterval(function () {
        for(var attr in json) {
            var current = 0;//获取非行间样式的值
            var stop=true;//判断是否所有属性值都到达目标值
            if (attr == 'opacity') {//判断是否为改变透明度
                current = Math.round(parseFloat(getStyle(obj, attr)) * 100);
            } else {
                current = parseInt(getStyle(obj, attr));
            }
            var speed = (json[attr] - current) / 10;//json[attr]目标值，非匀速变化
            speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
            if(current!=json[attr]){//如果有属性值没有到达目标值
                stop=false;
            }
            if (attr == 'opacity') {
                obj.style[attr] = 'filter(alpha' + (current + speed) + ')';
                obj.style[attr] = (current + speed) / 100;
            } else {
                obj.style[attr] = current + speed + 'px';
            }
        }
        if(stop){//如果所有属性都到达目标值，关闭定时器
            clearInterval(obj.timer);
            if(fn){
                fn();
            }
        }
    }, 30);
}