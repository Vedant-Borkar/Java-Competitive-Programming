#include <bits/stdc++.h>
#include <vector>
#include <algorithm>

struct Job {
    int id;
    int deadline;
    int profit;
};

bool compareJobs(const Job& a, const Job& b) {
    return a.profit > b.profit;
}

int scheduleJobs(std::vector<Job>& jobs, int maxDeadline) {
    std::sort(jobs.begin(), jobs.end(), compareJobs);
    
    std::vector<bool> slot(maxDeadline, false);
    int totalProfit = 0;
    
    for (const Job& job : jobs) {
        for (int i = std::min(maxDeadline, job.deadline) - 1; i >= 0; i--) {
            if (!slot[i]) {
                totalProfit += job.profit;
                slot[i] = true;
                break;
            }
        }
    }
    
    return totalProfit;
}

int main() {
    int n;
    std::cin >> n;  // Number of jobs

    std::vector<Job> jobs(n);
    int maxDeadline = 0;

    for (int i = 0; i < n; i++) {
        std::cin >> jobs[i].id >> jobs[i].profit;
        std::cin >> jobs[i].deadline;
        maxDeadline = std::max(maxDeadline, jobs[i].deadline);
    }

    int totalProfit = scheduleJobs(jobs, maxDeadline);
    
    std::cout << totalProfit << std::endl;

    return 0;
}