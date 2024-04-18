def cscan_disk():
    queue = [0] * 20
    n = int(input("Enter the size of queue request: "))
    head = int(input("Enter the initial head position: "))
    max_range = int(input("Enter the max range of disk: "))

    print("Enter the queue of disk positions to be read:")
    queue1 = [int(input()) for _ in range(n)]
    queue1.sort()
    queue2 = [x for x in queue1 if x < head]
    queue1 = [x for x in queue1 if x >= head]

    i = 1
    for j in range(len(queue1)):
        queue[i] = queue1[j]
        i += 1
    queue[i] = max_range
    queue[i + 1] = 0
    i = len(queue1) + 3
    for j in range(len(queue2)):
        queue[i] = queue2[j]
        i += 1

    seek = 0
    for j in range(n + 1):
        diff = abs(queue[j + 1] - queue[j])
        seek += diff
        print(f"Disk head moves from {queue[j]} to {queue[j + 1]} with seek {diff}")

    print(f"Total seek time is {seek}")
    print(f"Average seek time is {seek / n:.2f}")


if __name__ == "__main__":
    cscan_disk()
