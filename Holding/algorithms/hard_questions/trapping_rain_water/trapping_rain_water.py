class trapping_rain_water(object):
    def trap(self, height):
        # Create two pointers
        ptr_left = 0
        ptr_right = len(height) - 1
        
        # Track max height between left and right.
        left_max = height[ptr_left]
        right_max = height[ptr_right]
        sum_height = 0
        
        # Loop through height adjusting the pointers.
        while ptr_left < ptr_right:
            if left_max <= right_max:
                sum_height += (left_max - height[ptr_left])
                ptr_left += 1
                left_max = max(left_max, height[ptr_left])
            else:
                sum_height += (right_max - height[ptr_right])
                ptr_right -= 1
                right_max = max(right_max, height[ptr_right])
        
        return sum_height

# Example 1
trap = trapping_rain_water

height1 = [0,1,0,2,1,0,1,3,2,1,2,1]
print(f'Example 1: {trapping_rain_water.trap(trap, height1)}')

# Example 2
height2 = [4,2,0,3,2,5]
print(f'Example 2: {trapping_rain_water.trap(trap, height2)}')