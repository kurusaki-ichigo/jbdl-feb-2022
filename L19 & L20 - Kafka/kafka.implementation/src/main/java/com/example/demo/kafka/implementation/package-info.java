package com.example.demo.kafka.implementation;


/**
 *
 * # producer ---> broker <----- consumer reading message from broker
 *
 * # --- ack -- acknowledgment
 * #                       (3 brokers)
 * #
 *                                                  (broker)
 *     send a message                                 (b0) leader                             consumer
 *                                                   (b1)   follower
 *       (producer)                                  (b2)   follower
 *
 *      (pay -- topic , 10$ -- message)
 *                                      leader and follower
 *
 *
 *
 *
 *      3 possible configuration
 *
 *      acks = 0
 *     send a message but dont wait for ack          (b0) leader                             consumer
 *                                                   (b1)   follower
 *       (producer)   ------------------------------ (b2)   follower
 *
 *      (pay -- topic , 10$ -- message)
 *
 *
 *      acks = 1
 *     send a message                                   (b0) leader                             consumer
 *                                                      (b1)   follower
 *       (producer)   ------------------------------    (b2)   follower
 *                  (ack from the leader)
 *      (pay -- topic , 10$ -- message)
 *
 *
 *       *      acks = all
 *  *     send a message                                   (b0) leader                             consumer
 *  *                                                      (b1)   follower
 *  *       (producer)   ------------------------------    (b2)   follower
 *  *                  (ack from the leader)
 *  *      (pay -- topic , 10$ -- message)
 *
 *
 *
 */