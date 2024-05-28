from threading import Lock
from threading import Barrier
from threading import Event
from threading import Semaphore
from threading import Condition

# This attempt uses two locks. The first thread unlocks the first lock, which allows the second thread
# to go. Once the second thread finishes, it unlocks the third thread, completing the three actions.
class attempt_locks:
    def __init__(self):
        self.locks = (Lock(),Lock())
        self.locks[0].acquire()
        self.locks[1].acquire()
        
    def first(self, printFirst):
        printFirst()
        self.locks[0].release()
        
    def second(self, printSecond):
        with self.locks[0]:
            printSecond()
            self.locks[1].release()
            
            
    def third(self, printThird):
        with self.locks[1]:
            printThird()

# Create two barriers, the second thread waits on the first barrier, while the first thread completes and 
# reaches the barrier, allowing the second thread to work. The third thread waits on the second barrier, which
# the second thread completes its action and reaches the barrier, allowing the third thread to work.
class attempte_barrier:
    def __init__(self):
        self.First_barrier = Barrier(2)
        self.Second_barrier = Barrier(2)
            
    def first(self, printFirst):
        printFirst()
        self.First_barrier.wait()
        
    def second(self, printSecond):
        self.First_barrier.wait()
        printSecond()
        self.Second_barrier.wait()
            
    def third(self, printThird):
        self.Second_barrier.wait()
        printThird()

# Create two events. The first event is set after the completion by the first thread, while the second thread waits
# for the completion of the event. After the first thread completes, it sets the event, allowing the second thread to work.
# The third thread waits on the second event, while the second thread completes its action and sets the second event, which
# allows the third thread to complete.
class attempt_event:
    def __init__(self):
        self.events = (Event(),Event())
        
    def first(self, printFirst):
        printFirst()
        self.events[0].set()
        
    def second(self, printSecond):
        self.events[0].wait()
        printSecond()
        self.events[1].set()
            
    def third(self, printThird):
        self.events[1].wait()
        printThird()

# Create two sempahore "Gates". The second thread and third thread waits on the first and second sempahore respectively.
# The first thread completes its action and then releases the first sempahore, allowing the second thread to work.
# Then, the second thread completes its action, and releases the second semaphore, allowing the third thread to work.
class attempt_semaphore:
    def __init__(self):
        self.gates = (Semaphore(0),Semaphore(0))
        
    def first(self, printFirst):
        printFirst()
        self.gates[0].release()
        
    def second(self, printSecond):
        with self.gates[0]:
            printSecond()
            self.gates[1].release()
            
    def third(self, printThird):
        with self.gates[1]:
            printThird()

# Create an order of lock acquisition. The first thread is always able to get a lock, while the second and third
# wait to acquire the lock in the order of acquisition established in the beginning. After the first thread completes
# the second thread is able to obtain a lock, from the wait_for function. After the second thread completes, the third
# is then allowed to operate.
class attempt_condition:
    def __init__(self):
        self.exec_condition = Condition()
        self.order = 0
        self.first_finish = lambda: self.order == 1
        self.second_finish = lambda: self.order == 2

    def first(self, printFirst):
        with self.exec_condition:
            printFirst()
            self.order = 1
            self.exec_condition.notify(2)

    def second(self, printSecond):
        with self.exec_condition:
            self.exec_condition.wait_for(self.first_finish)
            printSecond()
            self.order = 2
            self.exec_condition.notify()

    def third(self, printThird):
        with self.exec_condition:
            self.exec_condition.wait_for(self.second_finish)
            printThird()