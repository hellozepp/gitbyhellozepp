#!/usr/bin/env python
#--*-- coding:utf-8 --*--

import sys
import os
import time
import math
import gc

#川E36470@黄色,2015-12-01,13623971_13623972,43.4502,324,55.507,463,direct,339,3
#plate         day        dir_node      dist_fro speed_bef dist_tar  speed_aft   change_dir angle node_lvl
#皖A6C262@黄色,2015-12-01,104772_106344,230.9952,371,      82.1502,  385,        direct,    358,   1
def run():
    last_plate=''
    today=''
    left_speed=0
    left_cnt=0
    right_speed=0
    right_cnt=0
    back_speed=0
    back_cnt=0
    dire_speed=0
    dire_cnt=0
    for line in sys.stdin:
        line = line.strip()
        seg = line.split(',')
        plate  = seg[0]
        if len(seg) < 10:
            continue
        if today == '':
            today = seg[1]

        if last_plate == '':
            last_plate = plate
            if seg[7] == 'left':
                left_speed = int(seg[4]) #todo 类型转换
                left_cnt = 1
            elif seg[7] == 'right':
                right_speed = int(seg[4])
                right_cnt = 1
            elif seg[7] == 'back':
                back_speed = int(seg[4])
                back_cnt = 1
            elif seg[7] == 'direct':
                dire_speed = int(seg[4])
                dire_cnt = 1
        
        elif last_plate == plate:
            if seg[7] == 'left':
                left_speed += int(seg[4])
                left_cnt += 1
            elif seg[7] == 'right':
                right_speed += int(seg[4])
                right_cnt += 1
            elif seg[7] == 'back':
                back_speed += int(seg[4])
                back_cnt += 1
            elif seg[7] == 'direct':
                dire_speed += int(seg[4])
                dire_cnt += 1

        elif last_plate != plate:
            left_cnt_2 = left_cnt
            right_cnt_2 = right_cnt
            back_cnt_2 = back_cnt
            dire_cnt_2 = dire_cnt
            
            if left_cnt == 0:
                left_cnt_2 = 1
            if right_cnt == 0:
                right_cnt_2 = 1
            if back_cnt == 0:
                back_cnt_2 = 1
            if dire_cnt == 0:
                dire_cnt_2 = 1

            print(last_plate, today, left_speed / (left_cnt_2 * 10.0), left_cnt, right_speed / (10.0 * right_cnt_2),
                  right_cnt, back_speed / (10.0 * back_cnt_2), back_cnt, dire_speed / (10.0 * dire_cnt_2), dire_cnt,
                  left_cnt + right_cnt + back_cnt, left_cnt + right_cnt + back_cnt + dire_cnt)

            last_plate = plate
            left_speed=0
            left_cnt=0
            right_speed=0
            right_cnt=0
            back_speed=0
            back_cnt=0
            dire_speed = 0
            dire_cnt=0        
    
    
            if seg[7] == 'left':
                left_speed += int(seg[4])
                left_cnt += 1
            elif seg[7] == 'right':
                right_speed += int(seg[4])
                right_cnt += 1
            elif seg[7] == 'back':
                back_speed += int(seg[4])
                back_cnt += 1
            elif seg[7] == 'direct':
                dire_speed += int(seg[4])
                dire_cnt += 1


    left_cnt_2 = left_cnt
    right_cnt_2 = right_cnt
    back_cnt_2 = back_cnt
    dire_cnt_2 = dire_cnt
    if left_cnt == 0:
        left_cnt_2 = 1
    if right_cnt == 0:
        right_cnt_2 = 1
    if back_cnt == 0:
        back_cnt_2 = 1
    if dire_cnt == 0:
        dire_cnt_2 = 1

    print(last_plate, today, left_speed / (left_cnt_2 * 10.0), left_cnt, right_speed / (10.0 * right_cnt_2), right_cnt,
          back_speed / (10.0 * back_cnt_2), back_cnt, dire_speed / (10.0 * dire_cnt_2), dire_cnt,
          left_cnt + right_cnt + back_cnt, left_cnt + right_cnt + back_cnt + dire_cnt)


if __name__ == '__main__':
    run()
