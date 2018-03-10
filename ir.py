import RPi.GPIO as gpio
import time
gpio.setmode(gpio.BCM)
gpio.setup(2,gpio.IN)
while (True):
        i=gpio.input(2)
        if i==0 :
                print('interrupt'),i
                time.sleep(1)
        elif i==1 :
                print('no interrupt'),i
                time.sleep(1)
gpio.cleanup()
