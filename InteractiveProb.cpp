/**
 * Author: Vedant_Borkar
 * Problem:https://codeforces.com/contest/2001/problem/C
 * Name:C Problem
 */
#include <iostream>
#include <vector>
#include <unordered_map>
#include <cassert>
using namespace std;
#define MAX_NODES 1000

int performQuery(int node1, int node2) {
   cout << "? " << node1 << " " << node2 << endl;
   fflush(stdout);
   int response;
   cin >> response;
   return response;
}

void exploreConnections(int node1, int node2, vector<int>& visitedNodes, vector<pair<int, int>>& connections) {
   int connectedNode = performQuery(node1, node2);
   if (connectedNode == node1 || connectedNode == node2) {
       connections.push_back({node1, node2});
       visitedNodes[connectedNode] = 1;
       visitedNodes[node2] = 1;
       return;
   }
   if (visitedNodes[node1] && visitedNodes[connectedNode]) {
       exploreConnections(connectedNode, node2, visitedNodes, connections);
   } else {
       exploreConnections(node1, connectedNode, visitedNodes, connections);
       exploreConnections(connectedNode, node2, visitedNodes, connections);
   }
}

int main() {
   int testCases;
   cin >> testCases;
   while (testCases--) {
       int nodeCount;
       cin >> nodeCount;
       if (nodeCount == 2) {
           cout << "! 1 2" << endl;
           fflush(stdout);
           continue;
       }
       vector<int> visitedNodes(nodeCount + 1, 0);
       vector<pair<int, int>> connections;
       for (int i = 1; i < nodeCount; ++i) {
           for (int j = i + 1; j <= nodeCount; ++j) {
               if (visitedNodes[j]) continue;
               exploreConnections(i, j, visitedNodes, connections);
           }
       }
       cout << "!";
       for (const auto& connection : connections) {
           cout << " " << connection.first << " " << connection.second;
       }
       cout << endl;
       fflush(stdout);
   }
   return 0;
}