import matplotlib.pyplot as plt
import matplotlib.patches as mpatches

with open('merge.txt') as f:
	runtimesM = [int(line.strip()) for line in f]

with open('quick.txt') as f:
	runtimesQ = [int(line.strip()) for line in f]

with open('heap.txt') as f:
	runtimesH = [int(line.strip()) for line in f]
	
plt.hist(runtimesM,label='Mergesort')
plt.hist(runtimesQ,label='Quicksort')
plt.hist(runtimesH,label='Heapsort')
plt.legend(bbox_to_anchor=(0., 1.02, 1., .102), loc=2,
           ncol=3, mode="expand", borderaxespad=0.)
# plt.legend(bbox_to_anchor=(1.05, 1), loc=2, borderaxespad=0.)
plt.title('Sorting Algorithms')
plt.xlabel('Runtime (ms)')
plt.ylabel('Number of Runs')

plt.savefig('runtime.png')
plt.show()

