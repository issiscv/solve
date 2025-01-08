def solution(N, stages):
    stage_count = {}
    for stage in stages:
        stage_count.setdefault(stage, 0)
        stage_count[stage] += 1
    l = len(stages)

    fail_rate = {}
    for i in range(1, N + 1):
        if i in stage_count:
            fail_rate[i] = stage_count[i] / l
            l = l - stage_count[i]
        else:
            fail_rate[i] = 0

    return sorted(fail_rate, key=lambda x: (-fail_rate[x], x))


solution(5, [2, 1, 2, 6, 2, 4, 3, 3])
# solution(4, [4, 4, 4, 4, 4])
