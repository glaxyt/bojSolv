import math

IN = "IN"
OUT = "OUT"
day_to_minute = "23:59"

def solution(fees, records):
    answer = []
    basic_time, basic_fee, per_time, per_fee = fees
    total_time_record = dict()
    in_out_record = dict()
    
    def clock_to_minute(clock):
        h, m = map(int, clock.split(':'))
        minute = 60 * h + m
        return minute
    
    for record in records: 
        clock, car_num, entrance_type = record.split()
        
        if entrance_type == IN:
            in_out_record[car_num] = clock
            
        else:
            in_time = in_out_record[car_num]
            
            if total_time_record.get(car_num, False):
                total_time_record[car_num] += (clock_to_minute(clock) - clock_to_minute(in_time))
            else:
                total_time_record[car_num] = (clock_to_minute(clock) - clock_to_minute(in_time))
            del in_out_record[car_num]
            
    for car_num in in_out_record.keys():
        in_time = in_out_record[car_num]
        if total_time_record.get(car_num, False):
                total_time_record[car_num] += (clock_to_minute(day_to_minute) - clock_to_minute(in_time))
        else:
            total_time_record[car_num] = (clock_to_minute(day_to_minute) - clock_to_minute(in_time))
            print(total_time_record[car_num])

            
    for car_num in total_time_record.keys():
        time = total_time_record[car_num]
        time_except_basic_time = time - basic_time
        if time_except_basic_time < 0:
            answer.append([car_num, basic_fee])
        else:
            answer.append([car_num,  basic_fee + math.ceil(time_except_basic_time / per_time) * per_fee])
            
    answer.sort(key=lambda x: x[0])
    result = [x[1] for x in answer]
    return result