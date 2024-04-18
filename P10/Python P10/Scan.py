def scan_disk():
    LOW = 0
    HIGH = 199

    queue = []
    
    q_size = int(input("Input no of disk locations: "))
    head = int(input("Enter head position: "))

    print("Input elements into disk queue")
    for _ in range(q_size):
        queue.append(int(input()))

    queue.append(head)
    queue.sort()

    dloc = queue.index(head)

    if abs(head - LOW) <= abs(head - HIGH):
        for i in range(dloc, -1, -1):
            print(queue[i], "-->", end=" ")
        for i in range(dloc + 1, len(queue)):
            print(queue[i], "-->", end=" ")
    else:
        for i in range(dloc + 1, len(queue)):
            print(queue[i], "-->", end=" ")
        for i in range(dloc, -1, -1):
            print(queue[i], "-->", end=" ")

    print(f"\nmovement of total cylinders {head + queue[-1]}")


if __name__ == "__main__":
    scan_disk()
