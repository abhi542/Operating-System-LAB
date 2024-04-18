def fcfs_disk():
    t = [0] * 20
    tohm = [0] * 20

    n = int(input("Enter the no. of tracks: "))
    print("Enter the tracks to be traversed:")
    for i in range(2, n + 2):
        t[i] = int(input())

    tot = 0
    for i in range(1, n + 1):
        tohm[i] = abs(t[i + 1] - t[i])
        tot += tohm[i]

    avhm = tot / n
    print("Tracks traversed\tDifference between tracks")
    for i in range(1, n + 1):
        print(f"{t[i]}\t\t\t{tohm[i]}")

    print(f"\nAverage header movements: {avhm:.2f}")


if __name__ == "__main__":
    fcfs_disk()
