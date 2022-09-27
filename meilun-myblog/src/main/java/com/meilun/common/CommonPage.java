package com.meilun.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommonPage<T> extends Page<T> {

    protected long totalpage;      //总页数
    protected boolean isHavePre;   //是否有上一页
    protected boolean isHaveNext;  //是否有下一页

    protected long[] navigation;   //导航


    public void DetailProcess(){

        //计算总页数
        if(total%size==0){
            totalpage = total/size;
        }else {
            totalpage = total/size+1;
        }


        if(current <= 1){current=1; isHavePre=false;}
        if(current >= totalpage+1){current = totalpage; isHaveNext=false;}

        if(totalpage<8){
            navigation = new long[(int)totalpage];
            for (int i = 0;i<totalpage;i++){
                navigation[i] = i+1;
            }
        }else {
            navigation = new long[7];
            int i;

            if(current < 4){
                for ( i = 0; i < 7; i++) {
                    navigation[i] = i+1;
                }
            }else if(current > totalpage-3){
                for ( i = 6;i>=0;i--){
                    navigation[i] = totalpage-6+i;
                }
            }else {
                for (int j = 6; j >= 0; j--) {
                    navigation[j] = current-3+j;
                }
            }
        }

       if(current == 1 && totalpage !=0){
            isHaveNext = true;
        }

        if(current == totalpage && totalpage != 0 ){
            isHavePre = true;
        }

        if(current !=1 && current !=totalpage && totalpage !=1){
            isHavePre = true;
            isHaveNext = true;
        }


    }

}
